package com.xz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz
 */
@RestController
public class HelloController {
    @RequestMapping("/linux.ico")
    public String hello() {
        return "你好";
    }
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
