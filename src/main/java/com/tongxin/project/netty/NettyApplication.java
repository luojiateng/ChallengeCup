package com.tongxin.project.netty;

import com.tongxin.project.netty.main.NettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @Description:
 * @Title: NettyApplication
 * @ProjectName: xsyu
 * @date: 2022/3/24 14:52
 * @author: Luo
 */
@SpringBootApplication
@Slf4j
public class NettyApplication implements CommandLineRunner {
    @Resource
    private NettyServer nettyServer;

    @Override
    public void run(String... args) {
        try {
            nettyServer.start();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("{}", e);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            nettyServer.destory();
        }));
    }
}
