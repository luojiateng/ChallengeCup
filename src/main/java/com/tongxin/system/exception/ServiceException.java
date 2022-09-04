package com.tongxin.system.exception;

import com.tongxin.common.enums.BusinessExceptionEnum;
import lombok.Data;
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
    private static final long serialVersionUID = -7480022450501760611L;
    private String code;
    private String msg;

    public ServiceException(BusinessExceptionEnum businessExceptionEnum) {
        this.msg = businessExceptionEnum.getMsg();
        this.code = businessExceptionEnum.getCode();
    }
}
