package com.tongxin.common.enums;

import com.tongxin.common.constant.Constant;

public enum BusinessExceptionEnum {
    CLIENT_EXCEPTION(Constant.HTTP_400,"请求异常"),
    AUTH_EXCEPTION(Constant.HTTP_401, "Token验证失败"),
    USERNAME_PASSWORD_EXCEPTION(Constant.HTTP_403, "用户密码错误"),
    SERVER_EXCEPTION(Constant.HTTP_404, "请求资源不存在"),
    SOURCE_EXCEPTION(Constant.HTTP_500, "服务器异常"),
    BUSINESS_EXCEPTION(Constant.HTTP_501, "业务异常");

    private String code;
    private String msg;

    private BusinessExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
