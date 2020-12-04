package io.zerofruit.tasync.concurrent;

import java.util.concurrent.Future;

public interface EventExecutor extends EventExecutorGroup {
    /**
     * Returns a reference to itself.
     */
    @Override
    EventExecutor next();

    EventExecutorGroup parent();

    boolean inEventLoop();
    boolean inEventLoop(Thread thread);

    <V> Promise<V> newPromise();
    <V> Future<V> newSuccessedFuture(V result);
    <V> Future<V> newFailedFuture(Throwable cause);
}
