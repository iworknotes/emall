package com.cc.example.exception;

import com.cc.api.CommonResult;
import com.cc.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 *
 * @author YL.huang
 * @date 04/16/2020
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(Thread.currentThread().getClass());

    @ExceptionHandler({Exception.class})// 指定拦截异常的类型
    @ResponseStatus(HttpStatus.OK)// 自定义浏览器返回状态码
    @ResponseBody
    public CommonResult handle(Exception ex) {
        logger.error(ex.getMessage(), ex);
        if (ex instanceof ApiException) {
            ApiException exception = (ApiException) ex;
            if (exception.getErrorCode() != null) {
                return CommonResult.getInstance(exception.getErrorCode(), null);
            }
        }
        return CommonResult.failed(null, ex.getMessage());
    }
}