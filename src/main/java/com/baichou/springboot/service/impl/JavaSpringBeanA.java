package com.baichou.springboot.service.impl;/**
 * Created by root on 16-10-25.
 */

import com.baichou.springboot.service.JavaSpringBean;

/**
 * 通过javabean创建spring对象实现
 *
 * @author zyang0419
 * @create 2016-10-25 下午5:19
 **/
public class JavaSpringBeanA  implements JavaSpringBean{

    @Override
    public void display() {
        System.out.println("******************JavaSpringBean A *******************************************");
    }
}
