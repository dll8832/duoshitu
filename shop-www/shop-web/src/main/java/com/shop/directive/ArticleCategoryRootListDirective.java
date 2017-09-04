package com.shop.directive;

import com.shop.model.ArticleCategory;
import com.shop.model.Promotion;
import com.shop.service.ArticleCategoryService;
import com.shop.service.PromotionService;
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
public class ArticleCategoryRootListDirective extends BaseDirective {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {
        // 获取参数
        Integer limit = getParamter(params, "count", Integer.class);

        // 获取数据
        List<ArticleCategory> articleCategories = articleCategoryService.findList(limit);

        // 输出数据
        setVariable(env, body, "articleCategories", articleCategories);

    }
}
