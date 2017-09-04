package com.shop.directive;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by TW on 2017/8/25.
 */
public abstract class BaseDirective implements TemplateDirectiveModel {


    /**
     * 获取参数值
     * @param params
     * @param paramName
     * @param clazz
     * @param <T>
     * @return
     * @throws TemplateException
     */
    public <T> T getParamter(Map params, String paramName, Class<?> clazz)
            throws TemplateException {
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        // 获取参数
        TemplateModel templateModel = (TemplateModel) params.get(paramName);
        T value = (T)beansWrapper.unwrap(templateModel, clazz);
        return value;
    }


    /**
     * 输出
     * @param env
     * @param body
     * @param key
     * @param result
     * @throws Exception
     */
    public void setVariable(Environment env, TemplateDirectiveBody body,
                            String key, Object result)
            throws TemplateException, IOException {

        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        // 输出数据
        TemplateModel templateModel = beansWrapper.wrap(result);
        env.setVariable(key, templateModel);
        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(result));
        }
    }

}
