package com.tongxin.project.common;

import com.tongxin.common.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Title: AjaxResult
 * @ProjectName: springboot
 * @date: 2022/4/14 21:43
 * @author: Luo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult {
    private String code;//响应码
    private String msg;//携带信息
    private Object data;//数据

    /**
     * 返回成功的数据
     *
     * @param data
     * @return
     */
    public static AjaxResult success(Object data) {
        return new AjaxResult(Constant.HTTP_200, "", data);
    }

    /**
     * 默认成功
     *
     * @return
     */
    public static AjaxResult success() {
        return new AjaxResult(Constant.HTTP_200, "请求成功", null);
    }

    /**
     * 自定义错误
     *
     * @param code
     * @param msg
     * @return
     */
    public static AjaxResult error(String code, String msg) {

        return new AjaxResult(code, msg, null);
    }

    /**
     * 默认错误
     */
    public static AjaxResult error() {
        return new AjaxResult(Constant.HTTP_500, "系统错误", null);
    }
}
