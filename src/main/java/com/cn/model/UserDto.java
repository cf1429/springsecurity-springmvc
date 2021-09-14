package com.cn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:chenf
 * @Date:2021/9/14 15:38
 * @describe
 */
@Data
@AllArgsConstructor
public class UserDto {
    //用户身份信息
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
