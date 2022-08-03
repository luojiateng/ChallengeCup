package com.tongxin.project.netty.main;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Slf4j
@Component
public class NettyServer {
    @Resource(name = "boss")
    private NioEventLoopGroup boss;
    @Resource(name = "worker")
    private NioEventLoopGroup worker;
    @Resource
    private NettyInitializerHandler nettyInitializerHandler;
    @Resource
    private ServerBootstrap serverBootstrap;
    @Value("${netty.port}")
    public Integer PORT;
    @Value("${netty.inetHost}")
    public String INET_HOST;

    /**
     * netty服务器核心代码
     *
     * @throws Exception
     */
    public void start() throws Exception {
        serverBootstrap.group(boss, worker);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(nettyInitializerHandler);
        ChannelFuture channelFuture = serverBootstrap.bind(INET_HOST, PORT).sync();
        channelFuture.channel().closeFuture().sync();
    }

    /**
     * netty服务器关闭后操作
     */
    public void destory() {
        boss.shutdownGracefully();
        worker.shutdownGracefully();
    }
}
