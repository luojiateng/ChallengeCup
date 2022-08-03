package com.tongxin.project.netty.protocol;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.springframework.stereotype.Component;

/**
 * @Description: 帧接收器，规定接收的字节已经内容的长度
 * @Title: ProcotolFrameDecoder
 * @ProjectName: xsyu
 * @date: 2022/3/25 0:16
 * @author: Luo
 */
@Component
public class ProcotolFrameDecoder extends LengthFieldBasedFrameDecoder {

    public ProcotolFrameDecoder() {
        this(2048, 12, 4, 0, 0);
    }

    public ProcotolFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }
}
