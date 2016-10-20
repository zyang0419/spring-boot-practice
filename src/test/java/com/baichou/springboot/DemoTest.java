package com.baichou.springboot;

import com.baichou.springboot.model.Demo;
import com.baichou.springboot.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by root on 16-10-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)// 指定spring-boot的启动类
//@SpringApplicationConfiguration(classes = Application.class)// 1.4.0 前版本
public class DemoTest {
    @Autowired
    private DemoService demoService;

    @Test
    public void findUserById()  {
        Demo demo = demoService.findById(1);
        System.out.println(demo);
        System.out.println("test test test");
    }



    }
