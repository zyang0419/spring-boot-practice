package com.baichou.springboot.controller;/**
 * Created by root on 16-10-25.
 */

import com.baichou.springboot.model.DemoInfo;
import com.baichou.springboot.service.DemoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * demoInfo控制器类
 *
 * @author zyang0419
 * @create 2016-10-25 上午9:50
 **/
@Controller
public class DemoInfoController  {

        @Autowired
        private DemoInfoService demoInfoService;

        @RequestMapping("/test")
        public@ResponseBody String test(){
            DemoInfo loaded = demoInfoService.findById(1);
            System.out.println("loaded="+loaded);
            DemoInfo cached = demoInfoService.findById(1);
            System.out.println("cached="+cached);
            loaded = demoInfoService.findById(2);
            System.out.println("loaded2="+loaded);
            return "ok";

        }

        @RequestMapping("/delete")
        public@ResponseBody String delete(long id){
            demoInfoService.deleteFromCache(id);
            return "ok";

        }

        @RequestMapping("/test1")
        public@ResponseBody  String test1(){
            demoInfoService.test();
            System.out.println("DemoInfoController.test1()");
            return "ok";

        }

}
