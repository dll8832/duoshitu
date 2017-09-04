package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.base.ResultInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by TW on 2017/8/22.
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @RequestMapping("test")
    public String test(Model model) {

        model.addAttribute("realName", null);
        model.addAttribute("userId", 1000000);
        model.addAttribute("isMan", true);
        model.addAttribute("createDate", new Date());

        return "test";
    }

    @RequestMapping("hello")
    public String hello(Model model) {
        return "hello";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request) throws Exception {

        // 找个一个静态页面
        String path = request.getServletContext().getRealPath("/html");
        String indexName = "index.html";
        File file = new File(path + "/" + indexName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            return "forward:html/" + indexName;
        }
        file.createNewFile();

        OutputStreamWriter out = new OutputStreamWriter(
                new FileOutputStream(file), "utf-8");

        Configuration cfg = freeMarkerConfigurer.getConfiguration();
        Template template = cfg.getTemplate("index.ftl", "UTF-8");
        // 输出到静态页
        template.process(null, out);

        return "forward:html/" + indexName;
    }

    @RequestMapping("index.html")
    public String indexHtml(HttpServletRequest request) throws Exception {
        Configuration cfg = freeMarkerConfigurer.getConfiguration();
        Template template = cfg.getTemplate("index.ftl");

        //html生成之后存放的路径
        String dirPath = request.getSession().getServletContext().getRealPath("/html");

        //生成的文件的名字
        String indexFileName = "index.html";
        File file = new File(dirPath + "/" + indexFileName);
        // 判断文件是否存在
        if (file.exists()) {
            return "forward:html/index.html";
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        Writer out = new OutputStreamWriter(new FileOutputStream(dirPath+"/"+indexFileName),"UTF-8");
        template.process(null, out);
        return "forward:html/index.html";
    }
}
