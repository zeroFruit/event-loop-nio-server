package io.zerofruit.tasync.bootstrap;

import io.zerofruit.tasync.common.ObjectUtil;
import io.zerofruit.tasync.channel.Channel;
import io.zerofruit.tasync.channel.EventLoopGroup;

public abstract class AbstractBootstrapConfig<B extends AbstractBootstrap<B, C>, C extends Channel> {

    protected final B bootstrap;

    protected AbstractBootstrapConfig(B bootstrap) {
        this.bootstrap = ObjectUtil.checkNotNull(bootstrap, "bootstrap");
    }

    /**
     * Returns the configured {@link EventLoopGroup} or {@code null} if non is configured yet.
     */
    public final EventLoopGroup group() {
        return bootstrap.group();
    }
}
