package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.model.ProductCategory;
import com.shop.service.ProductCategoryService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/8/25.
 */
@Component
public class ProductCategoryChildrenListDirective extends BaseDirective {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {
        // 获取参数
        Integer parentId = getParamter(params, "parentId", Integer.class);
        Integer limit = getParamter(params, "count", Integer.class);
        // 获取数据
        List<ProductCategory> productCategories = productCategoryService.findChilrenList(parentId, limit);
        // 输出数据
        setVariable(env, body, "productCategories", productCategories);
    }
}
