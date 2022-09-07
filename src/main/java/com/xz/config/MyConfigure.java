package com.xz.config;

import com.xz.entity.Car;
import com.xz.entity.Pet;
import com.xz.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xz
 * `@Configuration` 告诉 SpringBoot 这是一个配置类 == 配置文件
 * 1. 配置类本身也是组件
 * 2. proxyBeanMethods: 代理 bean 的方法
 */
@Import({User.class})
@Configuration(proxyBeanMethods = true)
//@EnableConfigurationProperties(Car.class)
public class MyConfigure {

    /**
     * 给容器中添加组件, 以方法名作为组件 id。
     * 返回类型就是组件类型, 返回的值就是组件在容器中的实例。
     */
    @ConditionalOnBean(name = "tom22")
    @Bean
    public User user01() {
        return new User("张三", 18);
    }

//    @Bean("tom")
//    public Pet tomcatPet() {
//        return new Pet("tomcat");
//    }
}
