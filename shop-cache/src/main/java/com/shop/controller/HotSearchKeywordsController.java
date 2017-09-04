package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.base.ResultInfo;
import com.shop.service.HotSearchKeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by TW on 2017/8/24.
 */
@RestController
@RequestMapping("keywords")
public class HotSearchKeywordsController extends BaseController {

    @Autowired
    private HotSearchKeywordsService hotSearchKeywordsService;

    @RequestMapping("set")
    public ResultInfo setKeywords(String keywords) {
        Long count = hotSearchKeywordsService.setKeywords(keywords);
        return success(count);
    }

    @RequestMapping("get")
    public ResultInfo getKeywords() {
        List<String> keywords = hotSearchKeywordsService.getKeywords();
        return success(keywords);
    }

}
