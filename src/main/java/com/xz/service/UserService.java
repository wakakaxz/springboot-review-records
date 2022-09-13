package com.xz.service;

import com.xz.entity.User;
import com.xz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xz
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(Long id) {
        return userMapper.getUserById(id);

    }
}
