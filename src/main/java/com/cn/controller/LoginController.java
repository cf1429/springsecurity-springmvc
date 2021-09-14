package com.cn.controller;

import com.cn.model.AuthenticationRequest;
import com.cn.model.UserDto;
import com.cn.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author:chenf
 * @Date:2021/9/14 16:01
 * @describe
 */
@RestController
public class LoginController {
    @Autowired
    AuthenticationService authenticationService;

    /**
     * 登录接口
     * @param authenticationRequest
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession httpSession){
        UserDto authentication = authenticationService.authentication(authenticationRequest);
        // 将用户信息存入session中
        httpSession.setAttribute(UserDto.SESSION_USER_KEY,authentication);
        return authentication.getUsername()+"登录成功";
    }


    /**
     * 测试session会话，通过从session中获取用户信息来判断是否登录过
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/test/testSession",produces = "text/plain;charset=utf-8" )
    public String testSession(HttpSession httpSession){
        String fullname = null;
        Object obj = httpSession.getAttribute(UserDto.SESSION_USER_KEY);
        if(obj == null ){
            fullname = "匿名用户";
        }else{
            UserDto userDto = (UserDto) obj;
            fullname = userDto.getFullname();
        }
        return fullname+"访问资源";
    }

    /**
     * 退出
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/logout", produces = "text/plain;charset=utf-8")
    public String logout(HttpSession httpSession){
        // 清空session中的用户信息
        httpSession.removeAttribute(UserDto.SESSION_USER_KEY);
        return "退出成功";
    }

}
