package io.zerofruit.tasync.concurrent;

public final class SuccessedFuture<V> extends CompleteFuture<V> {
    private final V result;

    public SuccessedFuture(EventExecutor executor, V result) {
        super(executor);
        this.result = result;
    }

    @Override
    public Throwable cause() {
        return null;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public V getNow() {
        return result;
    }
}
