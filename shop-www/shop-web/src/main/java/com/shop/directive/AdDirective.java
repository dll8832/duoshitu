package com.shop.directive;

import com.shop.model.Ad;
import com.shop.model.AdPosition;
import com.shop.service.AdPositionService;
import com.shop.service.AdService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/8/25.
 */
@Component
public class AdDirective extends BaseDirective {

    @Autowired
    private AdService adService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {
        // 获取参数
        Integer positionId = getParamter(params, "positionId", Integer.class);
        // 获取数据
        List<Ad> ads = adService.findPositionAds(positionId);
        // 输出
        setVariable(env, body, "ads", ads);
    }
}
