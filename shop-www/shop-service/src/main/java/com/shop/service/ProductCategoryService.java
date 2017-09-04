package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.ProductCategoryDao;
import com.shop.model.ProductCategory;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/24.
 */
@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * 获取根级分类
     * @return
     * @param limit
     */
    public List<ProductCategory> findRootList(Integer limit) {
        if (limit == null) {
            limit = Constant.SIX;
        }
        List<ProductCategory> productCategories = productCategoryDao.findRootList(limit);
        return productCategories;
    }

    /**
     * 根据父级id查询子级
     * @param parentId
     * @return
     */
    public List<ProductCategory> findChilrenList(Integer parentId, Integer limit) {
        AssertUtil.intIsNotEmpty(parentId);
        if (limit == null) {
            limit = Constant.THREE;
        }
        List<ProductCategory> productCategories = productCategoryDao.findChildrenList(parentId, limit);
        return productCategories;
    }
}
