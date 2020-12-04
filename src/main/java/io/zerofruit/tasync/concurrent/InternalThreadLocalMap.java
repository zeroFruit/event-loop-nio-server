package io.zerofruit.tasync.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The internal data structure that stores the thread-local variables for Netty and all FastThreadLocals.
 * Note that this class is for internal use only and is subject to change at any time.  Use FastThreadLocal
 * unless you know what you are doing.
 */
public final class InternalThreadLocalMap {
    static final AtomicInteger nextIndex = new AtomicInteger();

    // Core thread-locals
    int futureListenerStackDepth;

    public static InternalThreadLocalMap get() {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof FastThreadLocalThread)) {
            throw new IllegalStateException("current thread is not FastThreadLocalThread");
        }
        FastThreadLocalThread fastThread = (FastThreadLocalThread) thread;
        InternalThreadLocalMap threadLocalMap = fastThread.threadLocalMap();
        if (threadLocalMap == null) {
            fastThread.setThreadLocalMap(threadLocalMap = new InternalThreadLocalMap());
        }
        return threadLocalMap;
    }

    public static int nextVariableIndex() {
        int index = nextIndex.getAndIncrement();
        if (index < 0) {
            nextIndex.decrementAndGet();
            throw new IllegalStateException("too many thread-local indexed variables");
        }
        return index;
    }

    public int futureListenerStackDepth() {
        return futureListenerStackDepth;
    }

    public void setFutureListenerStackDepth(int futureListenerStackDepth) {
        this.futureListenerStackDepth = futureListenerStackDepth;
    }
}
