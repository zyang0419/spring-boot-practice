package com.baichou.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TemplateController {


    /**
     *
     * 处理静态文件
     浏览器页面使用HTML作为描述语言，那么必然也脱离不了CSS以及JavaScript。
     为了能够浏览器能够正确加载类似/css/style.css, /js/main.js等资源，
     默认情况下我们只需要在src/main/resources/static目录下添加css/style.css和js/main.js文件后，
     Spring MVC能够自动将他们发布，通过访问/css/style.css, /js/main.js也就可以正确加载这些资源。

     需要在src/main/resources下建立templates文件夹。Thymeleaf默认到templates下寻找对应名称的静态文件

     */
    @RequestMapping("/template/{name}")
    public String template(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "template";
    }

    /**
     * 返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","from TemplateController.helloHtml");
        return"/helloHtml";

    }

    /**
     * 返回html模板.
     */

    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("hello","from TemplateController.helloFtl");
        return"/helloFtl";

    }




}