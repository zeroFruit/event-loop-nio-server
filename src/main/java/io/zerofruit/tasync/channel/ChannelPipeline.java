package io.zerofruit.tasync.channel;

public interface ChannelPipeline {
    ChannelPipeline addLast(ChannelHandler... handlers);
}
