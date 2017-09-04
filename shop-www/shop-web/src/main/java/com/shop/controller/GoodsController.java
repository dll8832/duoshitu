package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.base.ResultInfo;
import com.shop.dto.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by TW on 2017/8/24.
 */
@RequestMapping("goods")
@Controller
public class GoodsController extends BaseController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("search")
    public String search(GoodsDto goodsDto, Model model) {
        return "goods/search";
    }

    @RequestMapping("list/{id}")
    public String list(@PathVariable Integer id, Model model) {

        // 调用缓存接口获取热门搜索关键字
        ResultInfo result = restTemplate.getForObject("http://localhost:8990/keywords/get",
                ResultInfo.class);
        List<String> keywords = (List<String>)result.getResult();
        model.addAttribute("keywords", keywords);
        return "goods";
    }
}
