package com.xz.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xz
 * `@Configuration` 告诉 SpringBoot 这是一个配置类 == 配置文件
 * 1. 配置类本身也是组件
 * 2. proxyBeanMethods: 代理 bean 的方法
 */
public class MyConfigure {

}
