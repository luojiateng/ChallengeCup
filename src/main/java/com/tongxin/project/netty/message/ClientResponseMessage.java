package com.tongxin.project.netty.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Title: ClientResponseMessage
 * @ProjectName: xsyu
 * @date: 2022/3/24 16:12
 * @author: Luo
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseMessage extends AbstractResponseMessage {

    private String userId;
    private String userGender;
    private List<String> visitHistory;
    private RiskLevel riskLevel;


    @Override
    public int getMessageType() {
        return ClientResponseMessage;
    }
}
