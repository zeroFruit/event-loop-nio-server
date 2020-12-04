package io.zerofruit.tasync.concurrent;

/**
 * A special Thread that provides fast access to {@link FastThreadLocal} variables
 * */
public class FastThreadLocalThread extends Thread {
    private InternalThreadLocalMap threadLocalMap;

    public final InternalThreadLocalMap threadLocalMap() {
        return this.threadLocalMap;
    }

    public final void setThreadLocalMap(InternalThreadLocalMap threadLocalMap) {
        this.threadLocalMap = threadLocalMap;
    }
}
