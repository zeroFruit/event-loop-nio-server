package io.zerofruit.tasync.concurrent;

import java.util.concurrent.TimeUnit;

public interface Future<V> extends java.util.concurrent.Future<V> {

    /**
     * Returns true if and only if the I/O operation was completed successfully.
     * */
    boolean isSuccess();

    /**
     * Returns true if and only if the operation can be cancelled via cancel(boolean).
     * */
    boolean isCancellable();

    /**
     * Returns the cause of the failed I/O operation if the I/O operation has failed.
     * */
    Throwable cause();

    /**
     * Adds the specified listener to this future. The specified listener is notified when this future
     * is isDone(). If this future is already completed, the specified listener is notified immediately.
     * */
    Future<V> addListener(GenericFutureListener<? extends Future<? super V>> listener);

    /**
     * Removes the first occurrence of the specified listener from this future.
     * The specified listener is no longer notified when this future is isDone(). If the specified
     * listener is not associated with this future, this method does nothing and returns silently.
     * */
    Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> listener);

    /**
     * Waits for this future until it is done, and rethrows the cause of the failure if this future failed.
     * */
    Future<V> sync() throws InterruptedException;

    /**
     * Waits for this future to be completed.
     * */
    Future<V> await() throws InterruptedException;

    /**
     * Waits for this future to be completed within the specified time limit.
     * */
    boolean await(long timeout, TimeUnit unit) throws InterruptedException;

    /**
     * Return the result without blocking. If the future is not done yet this will return null.
     * As it is possible that a null value is used to mark the future as successful you also need to check
     * if the future is really done with isDone() and not rely on the returned null value.
     * */
    V getNow();
}
