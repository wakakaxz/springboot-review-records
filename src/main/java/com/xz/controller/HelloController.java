package com.xz.controller;

import com.xz.entity.User;
import com.xz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * @author xz
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public User getUserById(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        log.info("user: {}; user_createTime: {}", user.toString(), user.getGmtCreate());
        Date date = new Date();
        return user;
    }
}
