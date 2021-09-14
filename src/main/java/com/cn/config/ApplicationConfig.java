package com.cn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author:chenf
 * @Date:2021/9/14 14:23
 * @describe
 */
@Configuration
@ComponentScan(basePackages = "com.cn",
        excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
    //
}
