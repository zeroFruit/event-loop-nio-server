package io.zerofruit.tasync.channel;

import java.net.SocketAddress;

public interface ChannelOutboundInvoker {
    ChannelPromise newPromise();

    /**
     * Request to bind to the given {@link SocketAddress} and notify the {@link ChannelFuture} once the operation
     * completes, either because the operation was successful or because of an error.
     * The given {@link ChannelPromise} will be notified.
     */
    ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise);

    /**
     * Request to close the {@link Channel} and notify the {@link ChannelFuture} once the operation completes,
     * either because the operation was successful or because of
     * an error.
     *
     * After it is closed it is not possible to reuse it again.
     */
    ChannelFuture close();
}
