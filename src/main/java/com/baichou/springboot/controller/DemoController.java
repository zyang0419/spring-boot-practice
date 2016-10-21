package com.baichou.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.baichou.springboot.model.Demo;
import com.baichou.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/rest")
    public String rest(){
        String url = "http://localhost:9090/demo/json";
        JSONObject json = restTemplate.getForEntity(url, JSONObject.class).getBody();
        return json.toJSONString();
    }

    @RequestMapping("/json")
    public Object genJson(){
        JSONObject json = new JSONObject();
        json.put("descp", "this is spring rest template sample");
        return json;
    }

    /**********HTTP POST method**************/
    @RequestMapping("/postApi")
    public Object iAmPostApi(@RequestBody JSONObject parm){
        System.out.println(parm.toJSONString());
        parm.put("result", "hello post");
        return parm;
    }

    @RequestMapping("/post")
    public Object testPost(){
        String url = "http://localhost:9090/demo/postApi";
        JSONObject postData = new JSONObject();
        postData.put("descp", "request for post");
        JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
        return json.toJSONString();
    }


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
