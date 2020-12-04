package io.zerofruit.tasync.concurrent;

import java.util.EventListener;

/**
 * Listens to the result of a Future. The result of the asynchronous operation is
 * notified once this listener is added by calling Future#addListener(GenericFutureListener)
 */
public interface GenericFutureListener<F extends Future<?>> extends EventListener {
    /**
     * Invoked when the opreation associated with the Future has been completed
     */
    void operationComplete(F future) throws Exception;
}
