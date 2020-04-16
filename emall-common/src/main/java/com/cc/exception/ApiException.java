package com.cc.exception;

import com.cc.api.IResult;

/**
 * 自定义API异常
 *
 * @author YL.huang
 * @date 04/16/2020
 */
public class ApiException extends RuntimeException {

    private IResult result;

    public ApiException(IResult result) {
        super(result.getMessage());
        this.result = result;
    }

    public IResult getErrorCode() {
        return result;
    }
}
