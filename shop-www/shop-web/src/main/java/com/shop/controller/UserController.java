package com.shop.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shop.base.BaseController;
import com.shop.base.BaseDto;
import com.shop.base.ResultInfo;
import com.shop.model.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TW on 2017/8/22.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("find")
    @ResponseBody
    public ResultInfo find(BaseDto baseDto) {
        PageList<User> result = userService.find(baseDto);
        return success(result);
    }


}
