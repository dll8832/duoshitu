package com.shop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by TW on 2017/8/24.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        RedisTemplate<String, String > redisTemplate = ac.getBean(RedisTemplate.class);
        redisTemplate.boundValueOps("zhenghao").set("郑昊");
        System.out.println("写入成功");
        String value = redisTemplate.boundValueOps("zhenghao").get();
        System.out.println("获取的值：" + value);
    }
}
