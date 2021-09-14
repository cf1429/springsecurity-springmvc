package com.cn.config;

import com.cn.intercept.SimpleAuthenticationIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author:chenf
 * @Date:2021/9/14 14:25
 * @describe
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cn")
public class WebConfig implements WebMvcConfigurer {

    // 配置拦截器
    @Autowired
    private SimpleAuthenticationIntercept simpleAuthenticationIntercept;

    // 视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    // 配置自定义的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 加载自定义的拦截器，addPathPatterns("/test/**") 指定用于拦截的请求，如果不指定，会将登陆请求也拦截
        registry.addInterceptor(simpleAuthenticationIntercept).addPathPatterns("/test/**");
    }
}
