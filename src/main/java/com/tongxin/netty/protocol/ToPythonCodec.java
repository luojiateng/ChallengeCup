package com.tongxin.netty.protocol;

import com.tongxin.netty.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Description:
 * @Title: ToPythonCodec
 * @ProjectName: xsyu
 * @date: 2022/3/26 18:34
 * @author: Luo
 */
@Component
@Slf4j
@ChannelHandler.Sharable
public class ToPythonCodec extends MessageToMessageCodec<ByteBuf, Message> {
    @Value("${codec.magic}")
    private String magic;
    @Value("${codec.version}")
    private Integer version;

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> list) throws Exception {
        ByteBuf out = ctx.alloc().buffer();
        //1、魔数
        out.writeBytes(magic.getBytes(StandardCharsets.UTF_8));
        //2、版本号
        out.writeInt(version);
        //4、消息类型
        out.writeInt(msg.getMessageType());
        //6、正文长度
        byte[] bytes = Serializer.Algorithm.Json.serializer(msg);
        out.writeInt(bytes.length);
//        7、消息正文
        out.writeBytes(bytes);
        //8、将其传递给下一个Handler
        list.add(out);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> list) throws Exception {
        //1、魔数
        byte[] magicBytes = new byte[4];
        in.readBytes(magicBytes, 0, 4);
        //2、版本号
        int version = in.readInt();
        //3、消息类型
        int messageType = in.readInt();//0,1,2
        //4、消息长度
        int length = in.readInt();
        byte[] bytes = new byte[length];
        in.readBytes(bytes, 0, length);
        //确定具体消息类型
        Class<?> messageClass = Message.getMessageClass(messageType);
        //将消息反序列化
        Object msg = Serializer.Algorithm.Json.deserializer(messageClass, bytes);
        System.out.println(msg);
        System.out.println("----------------");
        list.add(msg);
    }
}
