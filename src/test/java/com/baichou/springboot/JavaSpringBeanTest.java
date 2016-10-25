package com.baichou.springboot;

import com.baichou.springboot.service.impl.JavaSpringBeanA;
import com.baichou.springboot.service.impl.JavaSpringBeanB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by root on 16-10-19.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)// 指定spring-boot的启动类
public class JavaSpringBeanTest {

    @Resource(name = "javaSpringBeanA")
    private JavaSpringBeanA javaSpringBeanA;

    @Autowired
    @Qualifier("javaSpringBeanB")
    private JavaSpringBeanB javaSpringBeanB;
    @Test
    public void testBean() {
        javaSpringBeanA.display();
        javaSpringBeanB.display();

    }


}
