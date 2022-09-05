package com.xz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        return "Hello World！你好！";
    }
}
