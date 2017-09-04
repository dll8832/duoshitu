package com.shop.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shop.base.BaseDto;
import com.shop.dao.UserDao;
import com.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by TW on 2017/8/22.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public PageList<User> find(BaseDto baseDto) {

        PageList<User> users = userDao.find(baseDto.buildPageBounds());
        return users;
    }
}
