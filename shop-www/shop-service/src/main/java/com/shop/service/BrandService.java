package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.BrandDao;
import com.shop.dao.NavigationDao;
import com.shop.model.Brand;
import com.shop.model.Navigation;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/24.
 */
@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    /**
     * 获取分类下的品牌
     * @param productCategoryId
     * @return
     */
    public List<Brand> findProductCategoryBrands(Integer productCategoryId, Integer limit) {
        if (limit == null) {
            limit = Constant.FOUR;
        }
        List<Brand> brands = null;
        if (productCategoryId != null) {
            brands = brandDao.findCategoryBrandList(productCategoryId, limit);
        } else {
            brands = brandDao.findBrands(limit);
        }

        return brands;
    }
}
