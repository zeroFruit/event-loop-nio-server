package io.zerofruit.tasync.channel;

public abstract class ChannelInitializer<C extends Channel> extends ChannelInboundHandlerAdapter {
    /**
     * This method will be called once the {@link Channel} was registered. After the method returns this instance
     * will be removed from the {@link ChannelPipeline} of the {@link Channel}.
     */
    protected abstract void initChannel(C ch) throws Exception;
}
