package com.tongxin.common.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Title: NettyConfig
 * @ProjectName: xsyu
 * @date: 2022/3/24 15:27
 * @author: Luo
 */
@Configuration
public class NettyConfig {
    @Value("${netty.NioThreads.boss}")
    private Integer BOSS_THREADS = 1;
    @Value("${netty.NioThreads.worker}")
    private Integer WORKER_THREADS = 128;

    @Bean("boss")
    public NioEventLoopGroup getNioEventLoopGroupBoss() {
        return new NioEventLoopGroup(BOSS_THREADS);
    }

    @Bean("worker")
    public NioEventLoopGroup getNioEventLoopGroupWorker() {
        return new NioEventLoopGroup(WORKER_THREADS);
    }

    @Bean
    public ServerBootstrap getServerBootstrap() {
        return new ServerBootstrap();
    }

    @Bean
    public LoggingHandler getLoggingHandler() {
        return new LoggingHandler(LogLevel.DEBUG);
    }


}
