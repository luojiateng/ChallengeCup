package com.tongxin.common.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * @Description:
 * @Title: ThreadPoolConfig
 * @ProjectName: xsyu
 * @date: 2022/3/27 19:46
 * @author: Luo
 */

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean(value = "threadPoolInstance")
    public ExecutorService createThreadPoolInstance() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        return new ThreadPoolExecutor(10, 16, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

}
