package io.zerofruit.tasync.concurrent;

import io.zerofruit.tasync.common.ObjectUtil;

/**
 * The CompleteFuture which is failed already. It is recommended to use {@link EventExecutor#newFailedFuture(Throwable)}
 * instead of calling the constructor of this future.
 * */
public final class FailedFuture<V> extends CompleteFuture<V> {
    private final Throwable cause;

    public FailedFuture(EventExecutor executor, Throwable cause) {
        super(executor);
        this.cause = ObjectUtil.checkNotNull(cause, "cause");
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public Throwable cause() {
        return this.cause;
    }

    @Override
    public Future<V> sync() {
        throw (RuntimeException) cause;
    }

    @Override
    public V getNow() {
        return null;
    }
}
