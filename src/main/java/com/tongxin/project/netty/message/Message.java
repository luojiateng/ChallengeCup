package com.tongxin.project.netty.message;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Title: Message
 * @ProjectName: NettyReview
 * @date: 2022/3/21 22:50
 * @author: Luo
 */
@Component
public abstract class Message implements Serializable {
    public static Class<?> getMessageClass(int messageType) {
        return messageClasses.get(messageType);
    }

    protected Integer pingMessage = 0;
    protected Integer pongMessage = 0;

    public abstract int getMessageType();


    public static final int ClientRequestMessage = 1;
    public static final int ClientResponseMessage = 2;

    private static final Map<Integer, Class<?>> messageClasses = new HashMap<>();

    static {
        messageClasses.put(ClientRequestMessage, ClientRequestMessage.class);
        messageClasses.put(ClientResponseMessage, ClientResponseMessage.class);
    }
}

