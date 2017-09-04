package com.shop.service;

import com.shop.dao.AdDao;
import com.shop.model.Ad;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/25.
 */
@Service
public class AdService {
    @Autowired
    private AdDao adDao;

    /**
     * 查询广告位下的广告
     * @param positionId
     * @return
     */
    public List<Ad> findPositionAds(Integer positionId) {
        AssertUtil.intIsNotEmpty(positionId);
        List<Ad> ads = adDao.findPositionAds(positionId);
        return ads;
    }
}
