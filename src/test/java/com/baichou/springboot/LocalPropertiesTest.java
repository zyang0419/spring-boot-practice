package com.baichou.springboot;

import com.baichou.springboot.config.LocalSettings;
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
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
public class LocalPropertiesTest {
    @Autowired
    private LocalSettings localSettings;

    @Test
    public void testLocalProperties()  {
        System.out.println("LocalSettings**************************************"+localSettings.getGender());
        System.out.println("LocalSettings**************************************"+localSettings.getName());

    }


    }
