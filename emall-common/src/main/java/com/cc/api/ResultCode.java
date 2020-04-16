package com.cc.api;

/**
 * API返回状态码
 *
 * @author YL.huang
 * @date 04/14/2020
 */
public enum ResultCode implements IResult {

    SUCCESS(200, "成功"),
    FAILED(500, "失败");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
