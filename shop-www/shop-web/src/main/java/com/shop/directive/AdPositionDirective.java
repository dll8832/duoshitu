package com.shop.directive;

import com.shop.model.Ad;
import com.shop.model.AdPosition;
import com.shop.model.Brand;
import com.shop.service.AdPositionService;
import com.shop.service.BrandService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.print.attribute.standard.RequestingUserName;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/8/25.
 */
@Component
public class AdPositionDirective extends BaseDirective {

    @Autowired
    private AdPositionService adPositionService;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {
        // 获取参数
        Integer id = getParamter(params, "id", Integer.class);
        // 获取数据
        AdPosition adPosition = adPositionService.findById(id);
        // 模板内容
        String templateContent = adPosition.getTemplate();
        // 获取模板
        Configuration cfg = freeMarkerConfigurer.getConfiguration();
        Template template = new Template("adTemplate", templateContent, cfg);
        // 输出
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("adPosition", adPosition);
        template.process(dataModel, env.getOut());
    }
}
