package com.baichou.springboot.controller;

import com.baichou.springboot.model.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/demo")

public class DemoController {


    /**
     * 返回demo数据:
     * <p>
     * 请求地址：http://127.0.0.1:8080/demo/getDemo
     *
     * @return
     */

    @RequestMapping("/getDemo")
    public Demo getDemo() {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("Angel");
        return demo;
    }

    @RequestMapping("/deploy")
    public Demo deploy() {
        Demo demo = new Demo();
        demo.setId(12);
        demo.setName("HotDeploy");
        return demo;
    }



}
