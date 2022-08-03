package com.tongxin.project.netty.main;


import com.tongxin.project.netty.handler.ClientRequestMessageHandler;
import com.tongxin.project.netty.protocol.ProcotolFrameDecoder;
import com.tongxin.project.netty.protocol.ToPythonCodec;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @Title: NettyInitializerHandler
 * @ProjectName: xsyu
 * @date: 2022/3/24 14:45
 * @author: Luo
 */
@Component
@Slf4j
public class NettyInitializerHandler extends ChannelInitializer<NioSocketChannel> {
    @Resource
    private LoggingHandler loggingHandler;
    @Resource
    private ToPythonCodec toPythonCodec;
    @Resource
    private ClientRequestMessageHandler clientRequestMessageHandler;

    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new ProcotolFrameDecoder());
        pipeline.addLast(loggingHandler);
        pipeline.addLast(toPythonCodec);
        pipeline.addLast(clientRequestMessageHandler);
    }
}
