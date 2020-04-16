package com.cc.example.controller;

import com.cc.api.CommonResult;
import com.cc.api.IResult;
import com.cc.api.ResultCode;
import com.cc.example.entity.UserEntity;
import com.cc.example.service.IndexService;
import com.cc.exception.ApiException;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YL.huang
 * @date 04/15/2020
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(Thread.currentThread().getClass());

    @Autowired
    private IndexService indexService;

    @GetMapping("index")
    public String index() {
        logger.info("---> doing index");
        return "Hello SpringBoot";
    }

    @RequestMapping(value = "getUser2/{uid}")
    public CommonResult<UserEntity> getUser2(@PathVariable("uid") Long userId,
                                             @RequestParam(name = "name", defaultValue = "干吃面") String userName) {
        return CommonResult.success(new UserEntity(userId, userName));
    }

    @RequestMapping(value = {"getUser/{uid}"}, method = RequestMethod.POST)
    public CommonResult<UserEntity> getUser(@PathVariable("uid") Long uid, UserEntity user,
                                            @RequestHeader("access_token") String token,
                                            HttpServletRequest request) {
        logger.info("-----> uid=" + uid);
        user.setName(user.getName() + "_fix");
        System.out.println("token=" + token);
        System.out.println(request.getHeader("access_token"));
        return CommonResult.success(user);
    }

    @PostMapping(value = "getUser3")
    public CommonResult<UserEntity> getUser3(UserEntity user, Model model) {
        System.out.println(model.getAttribute("name"));
        System.out.println(user);
        return CommonResult.success(user);
    }

    @RequestMapping(value = "testError")
    public CommonResult testError() {
//        indexService.query();
//        System.out.println(1111);
        throw new ApiException(ResultCode.FAILED);
//        System.out.println(1 / 0);
//        return CommonResult.success(null);
    }

}
