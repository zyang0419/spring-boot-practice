package com.baichou.springboot.controller;/**
 * Created by root on 16-10-25.
 */

import com.baichou.springboot.model.DemoInfo;
import com.baichou.springboot.service.DemoInfoService;
import javassist.NotFoundException;
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


    @RequestMapping("/test2")

    public String test2(){

        //存入两条数据.
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setName("陈七");
        demoInfo.setPwd("123456");
        DemoInfo demoInfo2 = demoInfoService.save(demoInfo);

        //不走缓存.
        System.out.println(demoInfoService.findEHCacheById(demoInfo2.getId()));
        //走缓存.
        System.out.println(demoInfoService.findEHCacheById(demoInfo2.getId()));

        demoInfo = new DemoInfo();
        demoInfo.setName("赵六");
        demoInfo.setPwd("123456");
        DemoInfo demoInfo3 = demoInfoService.save(demoInfo);
        //不走缓存.
        System.out.println(demoInfoService.findEHCacheById(demoInfo3.getId()));
        //走缓存.
        System.out.println(demoInfoService.findEHCacheById(demoInfo3.getId()));
        System.out.println("============修改数据=====================");

        //修改数据.
        DemoInfo updated = new DemoInfo();
        updated.setName("赵六-updated");
        updated.setPwd("123456");
        updated.setId(demoInfo3.getId());
        try {
            System.out.println(demoInfoService.update(updated));
        } catch (NotFoundException e) {
            e.printStackTrace();

        }

        //不走缓存.
        System.out.println(demoInfoService.findEHCacheById(updated.getId()));
        return "ok";

    }



}
