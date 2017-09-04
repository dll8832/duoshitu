package com.shop.service;

import com.shop.constant.RedisKeyConstant;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Key;
import java.util.List;

/**
 * Created by TW on 2017/8/24.
 */
@Service
public class HotSearchKeywordsService {

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    /**
     * 把热门关键字存入redis
     * @param keywords
     * @return
     */
    public Long setKeywords(String keywords) { // 前台输入abc,bcd,dac
        AssertUtil.isNotEmpty(keywords, "请输入关键字");
        String [] keywordsArr = keywords.split(",");
//        Long count = redisTemplate.boundListOps(RedisKeyConstant.HOT_KEYWORDS)
//                .rightPushAll(keywordsArr);
        Long count = listOps.rightPushAll(RedisKeyConstant.HOT_KEYWORDS, keywordsArr);
        return count;
    }

    public List<String> getKeywords() {
//        List<String> result = redisTemplate.boundListOps(RedisKeyConstant.HOT_KEYWORDS)
//                .range(0, -1);
        List<String> result = listOps.range(RedisKeyConstant.HOT_KEYWORDS, 0, -1);
        return result;
    }
}
