package com.cn.service;

import com.cn.model.AuthenticationRequest;
import com.cn.model.UserDto;

/**
 * @Author:chenf
 * @Date:2021/9/14 15:35
 * @describe  用户认证请求
 */
public interface AuthenticationService  {
    /**
     * 用户认证
     * @param request 用户认证请求，账号和密码
     * @return 用户认证成功信息
     */
   UserDto authentication(AuthenticationRequest request);
}
