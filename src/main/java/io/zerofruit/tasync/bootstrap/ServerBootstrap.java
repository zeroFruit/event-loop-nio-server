package io.zerofruit.tasync.bootstrap;

import io.zerofruit.tasync.common.ObjectUtil;
import io.zerofruit.tasync.channel.Channel;
import io.zerofruit.tasync.channel.ChannelHandler;
import io.zerofruit.tasync.channel.EventLoopGroup;

import java.util.logging.Logger;

public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap, Channel> {
    private static final Logger logger = Logger.getLogger("ServerBootstrap.defaultLogger");

    private final ServerBootstrapConfig config = new ServerBootstrapConfig(this);

    private volatile EventLoopGroup childGroup;
    private volatile ChannelHandler childHandler;

    public ServerBootstrap() {}

    private ServerBootstrap(ServerBootstrap bootstrap) {
        super(bootstrap);
        childGroup = bootstrap.childGroup;
        childHandler = bootstrap.childHandler;
    }

    public ServerBootstrap group(EventLoopGroup parentGroup, EventLoopGroup childGroup) {
        super.group(parentGroup);
        if (this.childGroup != null) {
            throw new IllegalStateException("childGroup set already");
        }
        this.childGroup = ObjectUtil.checkNotNull(childGroup, "childGroup");
        return this;
    }

    public ServerBootstrap childHandler(ChannelHandler childHandler) {
        this.childHandler = ObjectUtil.checkNotNull(childHandler, "childHandler");
        return this;
    }

    @Override
    void init(Channel channel) throws Exception {

    }

    @Override
    public AbstractBootstrapConfig<ServerBootstrap, Channel> config() {
        return this.config;
    }
}
