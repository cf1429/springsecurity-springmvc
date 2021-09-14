package com.cn.service.imp;

import com.cn.model.AuthenticationRequest;
import com.cn.model.UserDto;
import com.cn.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author:chenf
 * @Date:2021/9/14 15:46
 * @describe
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public UserDto authentication(AuthenticationRequest request) {
        if(null != request && StringUtils.isEmpty(request.getUsername())
                && StringUtils.isEmpty(request.getPassword())){
            throw new RuntimeException("用户信息有误");

        }
        // 模拟查询数据库
        UserDto userDto = getUserDto(request.getUsername());
        if(userDto == null){
            throw new RuntimeException("用户不存在");
        }
        if(!request.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("密码错误");
        }
        // 校验通过，返回用户信息
        return userDto;
    }

    private UserDto getUserDto(String username){
        return userMap.get(username);
    }

    private Map<String,UserDto> userMap = new HashMap<>();
    // 静态代码块初始化数据，用来充当db存储数据
    {
        // 模拟数据权限，可以访问的接口
        Set<String> set1 = new HashSet<>();
        set1.add("testSession1");   // testSession1 充当/test/testSession1
        Set<String> set2 = new HashSet<>();
        set2.add("testSession2");   // testSession2 充当/test/testSession2


        userMap.put("zhangsan",new UserDto("1010","zhangsan","1234","张三","123456",set1));
        userMap.put("lisi",new UserDto("1011","lisi","1234","李四","123456",set2));
    }
}
