package com.xz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/testRandomId")
    public String testRandomId(@RequestBody Map<String, String> map) {
        System.out.println(map.get("uid"));
        return map.get("uid");
    }

    @GetMapping
    public String testRedis () {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("name", "xz");
        String name = (String) ops.get("name");
        return name;
    }

    @PostMapping("/test")
    public boolean test2 (String uid, String prodid) {
        // 判空
        if (uid == null || prodid == null) {
            return false;
        }

        // 拼接 key, 库存 key , 秒杀成功用户 key
        String kcKey = "sk:" + prodid + ":qt";
        String userKey = "sk:" + prodid + ":user";


        /*
        * 事务
        * */
        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                // 监视库存
                List<String> list = new ArrayList<>();
                list.add(kcKey);
                operations.watch(list);
                Object kc = redisTemplate.opsForValue().get(kcKey);

                // 获取库存, 若库存为 null, 秒杀未开始
                if (kc == null) {
                    System.out.println("秒杀活动未开始!");
                    return null;
                }

                // 判断是否重复秒杀操作
                if (Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(userKey, uid))) {
                    System.out.println("已经参与秒杀, 不能重复参与!");
                    return null;
                }

                // 判断如果商品数量 < 1, 秒杀结束, (再次获取)
                if ((Integer) kc < 1) {
                    System.out.println("秒杀已经结束!");
                    return null;
                }

                operations.multi();
                // 秒杀过程  库存 -1, 秒杀成功的用户添加进清单
                redisTemplate.opsForValue().decrement(kcKey);
                redisTemplate.opsForSet().add(userKey, uid);
                return operations.exec();
            }
        };

        List result = (List) redisTemplate.execute(sessionCallback);

        if (result == null || result.size() == 0) {
            System.out.println("秒杀失败了......");
            return false;
        }

        System.out.println("用户 " + uid + " 参与 " + prodid + " 的秒杀活动参与成功!");
        return true;
    }

    @GetMapping("/getSet")
    public String test3 () {
        ValueOperations ops = redisTemplate.opsForValue();
//        ops.set("hello", "world");
        String hello = (String) ops.get("hello");
        return hello;
    }
}
