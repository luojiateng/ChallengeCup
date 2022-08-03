package com.tongxin.project.netty.message;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Title: PongMessage
 * @ProjectName: NettyReview
 * @date: 2022/3/22 17:05
 * @author: Luo
 */
@Component
public class PongMessage extends Message {
    @Override
    public int getMessageType() {
        return pongMessage;
    }
}
