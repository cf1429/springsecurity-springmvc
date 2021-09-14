package com.cn.intercept;

import com.cn.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:chenf
 * @Date:2021/9/14 17:47
 * @describe  定义一个拦截器，用来判断是否具有访问权限，拦截器定义完成之后，一定要在配置文件webxml配置当中添加拦截器的配置
 * 即引入拦截器，让容器加载拦截器，从而让拦截器生效
 */
@Component
public class SimpleAuthenticationIntercept implements HandlerInterceptor {
    // 拦截所有的请求，先对请求进行判断
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取用户信息
        Object obj = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if(null == obj){
            writeContent(response,"请重新登录");
        }
        // 校验用户是否有请求接口的权限
        UserDto userDto = (UserDto) obj;
        // 获取用户的权限数据
        String requestURI = request.getRequestURI();
        // 判断用户自身的权限，及请求地址，根据如果符合判断条件，放行
        if(userDto.getAuthers().contains("testSession1") && requestURI.contains("/test/testSession1")){
            return true;
        }
        if(userDto.getAuthers().contains("testSession2") && requestURI.contains("/test/testSession2")){
            return true;
        }
        // 如果是其他情况提醒没有权限
        writeContent(response,"没有访问权限");
        return false;
    }


    public void writeContent(HttpServletResponse response, String msg) throws IOException {
        // 设置编码格式
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        // 响应中写入信息
        writer.println(msg);
        writer.close();
        response.resetBuffer();


    }
}
