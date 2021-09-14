package com.cn.controller;

import com.cn.model.AuthenticationRequest;
import com.cn.model.UserDto;
import com.cn.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chenf
 * @Date:2021/9/14 16:01
 * @describe
 */
@RestController
public class LoginController {
    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest){
        UserDto authentication = authenticationService.authentication(authenticationRequest);
        return authentication.getUsername()+"登录成功";

    }
}
