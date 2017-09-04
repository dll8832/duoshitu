package com.shop.service;

import com.shop.dao.NavigationDao;
import com.shop.model.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/24.
 */
@Service
public class NavigationService {

    @Autowired
    private NavigationDao navigationDao;

    public List<Navigation> findList(int position) {
        List<Navigation> navigations = navigationDao.findByPosition(position);
        return navigations;
    }
}
