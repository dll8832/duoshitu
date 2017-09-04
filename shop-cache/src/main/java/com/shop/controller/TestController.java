package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.base.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.x509.CertificateSubjectUniqueIdentity;

/**
 * Created by TW on 2017/8/24.
 */
@Controller
@RequestMapping("test")
public class TestController extends BaseController {
    // jdbcTemplate
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @RequestMapping("put")
    @ResponseBody
    public ResultInfo put(String name, String value) {
        redisTemplate.boundValueOps(name).set(value);
        return success("添加成功");
    }

    @RequestMapping("get")
    @ResponseBody
    public ResultInfo get(String name) {
       String value = redisTemplate.boundValueOps(name).get();
       return success(value);
    }

}
