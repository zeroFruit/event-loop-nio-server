package io.zerofruit.tasync.bootstrap;

import io.zerofruit.tasync.channel.Channel;

public interface ChannelFactory<T extends Channel> {
    T newChannel();
}
