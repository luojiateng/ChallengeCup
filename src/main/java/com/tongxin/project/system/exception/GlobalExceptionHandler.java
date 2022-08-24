package com.tongxin.project.system.exception;

import com.tongxin.project.common.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: web全局业务异常处理
 * @Title: GlobalExceptionHandler
 * @ProjectName: springboot
 * @date: 2022/4/14 22:05
 * @author: Luo
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 如果抛出的的是ServiceException，则调用该方法
     * @param exception 业务异常
     * @return AjaxResult
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public AjaxResult handle(ServiceException exception) {
        return AjaxResult.error(exception.getCode(), exception.getMessage());
    }
}
