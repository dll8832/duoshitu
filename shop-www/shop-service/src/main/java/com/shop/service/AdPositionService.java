package com.shop.service;

import com.shop.dao.AdPositionDao;
import com.shop.model.AdPosition;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by TW on 2017/8/25.
 */
@Service
public class AdPositionService {

    @Autowired
    private AdPositionDao adPositionDao;


    public AdPosition findById(Integer id) {
        AssertUtil.intIsNotEmpty(id);
        AdPosition adPosition = adPositionDao.findById(id);
        return adPosition;
    }
}
