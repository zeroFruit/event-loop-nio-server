package io.zerofruit.tasync.channel;

import io.zerofruit.tasync.concurrent.Future;
import io.zerofruit.tasync.concurrent.GenericFutureListener;

public interface ChannelFuture extends Future<Void> {
    /**
     * Returns a channel where the I/O operation associated with this
     * future takes place.
     */
    Channel channel();

    @Override
    ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> listener);

    @Override
    ChannelFuture removeListener(GenericFutureListener<? extends Future<? super Void>> listener);

    /**
     * Returns the cause of the failed I/O operation if the I/O operation has
     * failed.
     */
    Throwable cause();

    @Override
    ChannelFuture sync() throws InterruptedException;

    @Override
    ChannelFuture await() throws InterruptedException;

}
