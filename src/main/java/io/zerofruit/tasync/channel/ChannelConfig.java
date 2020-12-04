package io.zerofruit.tasync.channel;

import java.util.Map;

public interface ChannelConfig {
    Map<ChannelOption<?>, Object> getOptions();

    <T> T getOption(ChannelOption<T> option);

    <T> boolean setOption(ChannelOption<T> option, T value);

    int getConnectTimeoutMillis();

    ChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis);
}
