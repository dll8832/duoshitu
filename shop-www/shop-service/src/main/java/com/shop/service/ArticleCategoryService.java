package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.ArticleCategoryDao;
import com.shop.model.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/25.
 */
@Service
public class ArticleCategoryService {

    @Autowired
    private ArticleCategoryDao articleCategoryDao;

    public List<ArticleCategory> findList(Integer limit) {
        if (limit == null) {
            limit = Constant.TWO;
        }
        List<ArticleCategory> articleCategories = articleCategoryDao.findRootList(limit);
        return articleCategories;
    }
}
