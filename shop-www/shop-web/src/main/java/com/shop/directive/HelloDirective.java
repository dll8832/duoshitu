package com.shop.directive;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.BeanWrapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TW on 2017/8/24.
 */
@Component
public class HelloDirective implements TemplateDirectiveModel {


//    <@hello_world name = "haha">
//    ${helloworld.name?if_exists}:${helloworld.content?if_exists}
//		</@hello_world>


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        System.out.println("传入的参数: + " + params);
        // BeansWrapper是一个转换器， wrap()方法将对象包装成TemplateModel, unwrap()将templateModel转化成java类
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel nameTm = (TemplateModel)params.get("name");
        String name = (String)beansWrapper.unwrap(nameTm, String.class);
//        String name = (String)params.get("name");

        Map<String, Object> result = new HashMap();
        result.put("name", name);
        result.put("content", "HELLO FREEMARKER");

        // BeansWrapper是一个转换器， wrap()方法将对象包装成TemplateModel, unwrap()将templateModel转化成java类
//        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel templateModel = beansWrapper.wrap(result);
        env.setVariable("helloworld", templateModel);
        // 输出
        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(result));
        }


    }
}
