package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.ArticleDao;
import com.shop.model.Article;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/8/25.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 查询分类下的文章
     * @param categoryId
     * @param limit
     * @return
     */
    public List<Article> findList(Integer categoryId, Integer limit) {
        AssertUtil.intIsNotEmpty(categoryId);
        if (limit == null) {
            limit = Constant.TEN;
        }
        List<Article> articles = articleDao.findByCategoryId(categoryId, limit);
        return articles;
    }
}
