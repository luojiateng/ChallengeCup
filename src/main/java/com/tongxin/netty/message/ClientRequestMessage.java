package com.tongxin.netty.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @Description:
 * @Title: ClientRequestMessage
 * @ProjectName: xsyu
 * @date: 2022/3/24 16:12
 * @author: Luo
 */
@Component
@Data
@AllArgsConstructor
public class ClientRequestMessage extends Message {

    private String machineId;
    private Date time;
    private String userId;
    private String currentTemper;

    public ClientRequestMessage() {
    }

    @Override
    public int getMessageType() {
        return ClientRequestMessage;
    }
}
