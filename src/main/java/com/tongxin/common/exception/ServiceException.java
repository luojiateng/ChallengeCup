package com.tongxin.common.exception;

import lombok.Getter;

/**
 * @Description: service层异常处理
 * @Title: ServiceException
 * @ProjectName: springboot
 * @date: 2022/4/14 22:07
 * @author: Luo
 */
@Getter
public class ServiceException extends RuntimeException {
    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
