package com.cc.api;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 通用返回对象
 *
 * @author YL.huang
 * @date 04/14/2020
 */
public class CommonResult<T> {

    private int code;
    private String message;
    private T data;

    protected CommonResult() {

    }

    protected CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功
     *
     * @param data 返回的数据
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功
     *
     * @param data    返回的数据
     * @param message 提示信息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败
     *
     * @param data 返回的数据
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), data);
    }

    /**
     * 失败
     *
     * @param data    返回的数据
     * @param message 提示信息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(T data, String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, data);
    }

    /**
     * 通用返回结果设置
     *
     * @param result
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> getInstance(IResult result, T data) {
        return new CommonResult<>(result.getCode(), result.getMessage(), data);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
