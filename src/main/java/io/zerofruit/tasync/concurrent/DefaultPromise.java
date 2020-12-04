package io.zerofruit.tasync.concurrent;

import io.zerofruit.tasync.common.ObjectUtil;

import java.util.logging.Logger;

public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    private static final Logger logger = Logger.getLogger("DefaultPromise.defaultLogger");
    private static final Logger rejectedExecutionLogger = Logger.getLogger("DefaultPromise.rejectedExecutionLogger");

    private static final int MAX_LISTENER_STACK_DEPTH = 8;

    private final EventExecutor executor;

    protected DefaultPromise() {
        // only for subclasses
        executor = null;
    }

    public DefaultPromise(EventExecutor executor) {
        this.executor = ObjectUtil.checkNotNull(executor, "executor");
    }

    /**
     * Notify a listener that a future has completed.
     * */
    protected static void notifyListener(
            EventExecutor executor,
            final Future<?> future,
            final GenericFutureListener<?> listener
    ) {
        notifyListenerWithStackOverFlowProtection(
                ObjectUtil.checkNotNull(executor, "executor"),
                ObjectUtil.checkNotNull(future, "future"),
                ObjectUtil.checkNotNull(listener, "listener")
        );
    }

    /**
     * The logic in this method should be identical to notifyListeners() but
     * cannot share code because the listener(s) cannot be cached for an instance of DefaultPromise since the
     * listener(s) may be changed and is protected by a synchronized operation.
     */
    private static void notifyListenerWithStackOverFlowProtection(
            EventExecutor executor,
            final Future<?> future,
            final GenericFutureListener<?> listener
    ) {
        if (executor.inEventLoop()) {
            final InternalThreadLocalMap threadLocals = InternalThreadLocalMap.get();
            final int stackDepth = threadLocals.futureListenerStackDepth();
            if (stackDepth < MAX_LISTENER_STACK_DEPTH) {
                threadLocals.setFutureListenerStackDepth(stackDepth + 1);
                try {
                    notifyListener(future, listener);
                } finally {
                    threadLocals.setFutureListenerStackDepth(stackDepth);
                }
                return;
            }
        }
        safeExecute(executor, new Runnable() {
            @Override
            public void run() {
                notifyListener(future, listener);
            }
        });
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void notifyListener(Future future, GenericFutureListener l) {
        try {
            l.operationComplete(future);
        } catch (Throwable t) {
            logger.warning("An exception was thrown by " + l.getClass().getName() + ".operationComplete() " + t);
        }
    }

    private static void safeExecute(EventExecutor executor, Runnable task) {
        try {
            executor.execute(task);
        } catch (Throwable t) {
            rejectedExecutionLogger.severe("Failed to submit a listener notification task. Event loop shut down?" + t);
        }
    }
}
