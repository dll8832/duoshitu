package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.UrlConstant;
import com.shop.base.ResultInfo;
import com.shop.model.Navigation;
import com.shop.service.NavigationService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by TW on 2017/8/24.
 */
@Component
public class HotSearchKeywordsDirective implements TemplateDirectiveModel {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${app.cache.service-url}")
    private String appCacheServiceUrl;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        // 获取数据
        // 调用缓存接口获取热门搜索关键字
        String url = appCacheServiceUrl + UrlConstant.HOT_KEYWORDS_URL;
        ResultInfo result = restTemplate.getForObject(url, ResultInfo.class);
        List<String> keywords = (List<String>)result.getResult();

        // BeansWrapper是一个转换器， wrap()方法将对象包装成TemplateModel, unwrap()将templateModel转化成java类
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel templateModel = beansWrapper.wrap(keywords);
        env.setVariable("keywords", templateModel);
        // 输出
        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(keywords));
        }


    }
}
