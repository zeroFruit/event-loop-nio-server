package io.zerofruit.tasync.channel;

import io.zerofruit.tasync.common.ObjectUtil;
import io.zerofruit.tasync.concurrent.DefaultPromise;
import io.zerofruit.tasync.concurrent.EventExecutor;
import io.zerofruit.tasync.concurrent.Future;
import io.zerofruit.tasync.concurrent.GenericFutureListener;
import io.zerofruit.tasync.concurrent.Promise;

import java.util.concurrent.TimeUnit;


/**
 * The default {@link ChannelPromise} implementation.  It is recommended to use {@link Channel#newPromise()} to create
 * a new {@link ChannelPromise} rather than calling the constructor explicitly.
 */
public class DefaultChannelPromise extends DefaultPromise<Void> implements ChannelPromise {
    private final Channel channel;

    public DefaultChannelPromise(Channel channel) {
        super();
        this.channel = ObjectUtil.checkNotNull(channel, "channel");
    }

    public DefaultChannelPromise(Channel channel, EventExecutor executor) {
        super(executor);
        this.channel = ObjectUtil.checkNotNull(channel, "channel");
    }

    @Override
    public Channel channel() {
        return null;
    }

    @Override
    public Promise<Void> setSuccess(Void result) {
        return null;
    }

    @Override
    public ChannelPromise setFailure(Throwable cause) {
        return null;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isCancellable() {
        return false;
    }

    @Override
    public Throwable cause() {
        return null;
    }

    @Override
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        return null;
    }

    @Override
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        return null;
    }

    @Override
    public Future<Void> sync() throws InterruptedException {
        return null;
    }

    @Override
    public Future<Void> await() throws InterruptedException {
        return null;
    }

    @Override
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Void getNow() {
        return null;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }
}
