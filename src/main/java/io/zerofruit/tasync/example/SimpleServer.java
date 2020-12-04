package io.zerofruit.tasync.example;

import io.zerofruit.tasync.bootstrap.ServerBootstrap;
import io.zerofruit.tasync.channel.ChannelFuture;
import io.zerofruit.tasync.channel.ChannelInitializer;
import io.zerofruit.tasync.channel.EventLoopGroup;
import io.zerofruit.tasync.channel.nio.NioEventLoopGroup;
import io.zerofruit.tasync.channel.socket.SocketChannel;
import io.zerofruit.tasync.channel.socket.nio.NioServerSocketChannel;

public class SimpleServer {
    private int port;

    public SimpleServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new SimpleServerHandler());
                        }
                    });

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync();

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        new SimpleServer(port).run();
    }
}
