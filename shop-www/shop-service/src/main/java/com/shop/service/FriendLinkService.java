package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.FriendLinkDao;
import com.shop.model.FriendLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/26.
 */
@Service
public class FriendLinkService {
    
    @Autowired
    private FriendLinkDao friendLinkDao;


    public List<FriendLink> findList(Integer limit) {
        if (limit == null) {
            limit = Constant.TEN;
        }
        List<FriendLink> friendLinks = friendLinkDao.findList(limit);
        return friendLinks;
    }
}
