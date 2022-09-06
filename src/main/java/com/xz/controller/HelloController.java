package com.xz.controller;

import com.xz.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz
 */
@RestController
public class HelloController {

    @Autowired
    Car car;
//    public String han
    @RequestMapping("/car")
    public Car car() {
        return car;
    }
    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){
        return "Hello World！你好！" + name;
    }
}
