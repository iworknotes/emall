package com.cc.example.demo;

import com.cc.api.CommonResult;
import com.cc.api.ResultCode;
import com.cc.example.entity.UserEntity;

/**
 * @author YL.huang
 * @date 04/14/2020
 */
public class Demo_01 {

    public static void main(String[] args) {
        UserEntity user = new UserEntity(1L, "刘备");
        System.out.println(CommonResult.success(user));

        System.out.println(CommonResult.getInstance(ResultCode.FAILED, user));

    }

}
