package io.zerofruit.tasync.channel;

import io.zerofruit.tasync.common.AbstractConstant;

public class ChannelOption<T> extends AbstractConstant<ChannelOption<T>> {
    private ChannelOption(int id, String name) {
        super(id, name);
    }
}
