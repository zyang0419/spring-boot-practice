package com.baichou.springboot.controller;

import com.baichou.springboot.model.Demo;
import com.baichou.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * 测试保存数据方法.
     * @return
     */
    @RequestMapping("/save")
    public String save(){
        Demo d = new Demo();
        d.setName("Angel");
        demoService.save(d);//保存数据.
        return "ok.DemoController.save";
    }

    //地址：http://127.0.0.1:8080/demo/getById?id=1
    @RequestMapping("/getById")
    public Demo getById(long id){
        return demoService.getById(id);
    }

    //地址：http://127.0.0.1:8080/demo2/findById/1
    @RequestMapping("/findById/{id}")
    public Demo findById(@PathVariable long id){
        return demoService.findById(id);
    }

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
