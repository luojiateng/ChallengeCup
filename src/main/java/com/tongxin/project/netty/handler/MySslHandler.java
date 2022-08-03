package com.tongxin.project.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import java.nio.charset.StandardCharsets;

/**
 * @Description:
 * @Title: MySslHandler
 * @ProjectName: xsyu
 * @date: 2022/4/16 22:40
 * @author: Luo
 */

public class MySslHandler extends ChannelInitializer<NioSocketChannel> {
    private SslContext sslContext;
    private SslHandler sslHandler;

    @Override
    protected void initChannel(NioSocketChannel channel) throws Exception {
        //添加ssl安装验证
        channel.pipeline().addLast(sslContext.newHandler(channel.alloc()));
        //直接解析原始的HEX字节
        channel.pipeline().addLast(new StringEncoder(StandardCharsets.ISO_8859_1));
        //其他自定义Handler
        channel.pipeline().addLast();

    }
}
