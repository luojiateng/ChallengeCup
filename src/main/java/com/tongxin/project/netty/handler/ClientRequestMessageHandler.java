package com.tongxin.project.netty.handler;

import com.tongxin.project.netty.message.ClientRequestMessage;
import com.tongxin.project.netty.message.ClientResponseMessage;
import com.tongxin.project.netty.message.RiskLevel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Title: ClientRequestMessageHandler
 * @ProjectName: xsyu
 * @date: 2022/3/25 0:38
 * @author: Luo
 */
@Component
@ChannelHandler.Sharable
@Slf4j
public class ClientRequestMessageHandler extends SimpleChannelInboundHandler<ClientRequestMessage> {
    @Resource(name = "threadPoolInstance")
    private ExecutorService executorService;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ClientRequestMessage msg) throws Exception {
        String machineId = msg.getMachineId();
        Date time = msg.getTime();
        String userId = msg.getUserId();
        String currentTemper = msg.getCurrentTemper();

       // TODO 开启另一个线程拿到响应数据
        Future<ClientResponseMessage> future = executorService.submit(new Callable<ClientResponseMessage>() {
            @Override
            public ClientResponseMessage call() throws Exception {
                return new ClientResponseMessage(userId, "男", null, RiskLevel.LOW);
            }
        });


        ctx.writeAndFlush(future.get());
    }

}
