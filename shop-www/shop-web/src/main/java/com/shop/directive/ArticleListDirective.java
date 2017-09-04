package com.shop.directive;

import com.shop.model.Article;
import com.shop.model.ArticleCategory;
import com.shop.service.ArticleCategoryService;
import com.shop.service.ArticleService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/8/25.
 */
@Component
public class ArticleListDirective extends BaseDirective {

    @Autowired
    private ArticleService articleService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {
        // 获取参数
        Integer categoryId = getParamter(params, "categoryId", Integer.class);
        Integer limit = getParamter(params, "count", Integer.class);

        // 获取数据
        List<Article> articles = articleService.findList(categoryId, limit);

        // 输出数据
        setVariable(env, body, "articles", articles);

    }
}
