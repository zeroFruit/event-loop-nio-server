package io.zerofruit.tasync.concurrent;

public interface Promise<V> extends Future<V> {
    /**
     * Marks this future as a success and notifies all listeners
     *
     * If it is success or failed already it will throw an IllegalStateException
     * */
    Promise<V> setSuccess(V result);

    /**
     * Marks this future as a failure and notifies all listeners
     * */
    Promise<V> setFailure(Throwable cause);
}
