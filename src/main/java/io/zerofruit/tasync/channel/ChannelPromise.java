package io.zerofruit.tasync.channel;

import io.zerofruit.tasync.concurrent.Promise;

public interface ChannelPromise extends ChannelFuture, Promise<Void> {
    @Override
    Channel channel();
}
