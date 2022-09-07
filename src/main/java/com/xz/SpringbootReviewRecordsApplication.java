package com.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author xz
 */

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.xz")
@SpringBootApplication
public class SpringbootReviewRecordsApplication {

    public static void main(String[] args) {
        // 1. 返回我们 IOC 容器
//        ConfigurableApplicationContext run = SpringApplication.run(SpringbootReviewRecordsApplication.class, args);
        SpringApplication.run(SpringbootReviewRecordsApplication.class, args);

        // 2. 查看容器里面的组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

        // 3. 从容器中获取组件
//        Pet tom1 = run.getBean("tom", Pet.class);
//        Pet tom2 = run.getBean("tom", Pet.class);
//        System.out.println(tom1 == tom2);

//        MyConfigure bean = run.getBean(MyConfigure.class);
//        System.out.println(bean);
//        User user = bean.user01();
//        System.out.println(user);

        // 查看所有指定class的组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }

        // 查看是否有某个组件
//        System.out.println(run.containsBean("user01"));
    }
}
