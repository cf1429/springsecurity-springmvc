package com.cn.model;

import lombok.Data;

/**
 * @Author:chenf
 * @Date:2021/9/14 15:38
 * @describe
 */
@Data
public class AuthenticationRequest {
    //认证请求参数,用户名，密码
    private String username;

    private String password;
}
