package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.model.Navigation;
import com.shop.service.NavigationService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/8/24.
 */
@Component
public class NavigationDirective extends BaseDirective {

    @Autowired
    private NavigationService navigationService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        // 获取参数
        Integer position = getParamter(params, "position", Integer.class);

        // 获取数据
        List<Navigation> navigationList = navigationService.findList(position);

        // 输出
        setVariable(env, body, "navigations", navigationList);
    }
}
