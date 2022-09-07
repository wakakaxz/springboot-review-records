package com.xz.controller;

import com.xz.entity.Car;
import com.xz.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    Car car;

    @Autowired
    Person person;
    @RequestMapping("/car")
    public Car car() {
        return car;
    }
    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){
        log.info("/hello 请求进入");
        return "Hello World！你好！" + name;
    }
    @RequestMapping("/person")
    public Person person(){
        System.out.println(person.getUserName());
        return person;
    }
}
