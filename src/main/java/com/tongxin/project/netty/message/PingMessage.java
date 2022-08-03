package com.tongxin.project.netty.message;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Title: PingMessage
 * @ProjectName: NettyReview
 * @date: 2022/3/22 17:05
 * @author: Luo
 */
@Component
public class PingMessage extends Message {
    @Override
    public int getMessageType() {
        return pingMessage;
    }
}
