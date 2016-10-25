package com.baichou.springboot.config;/**
 * Created by root on 16-10-25.
 */

/**
 * xml配置类,不推荐使用
 * Spring Boot理念就是零配置编程，但是如果绝对需要使用XML的配置，
 * 建议从一个@Configuration类开始，你可以使用@ImportResouce注解加载XML配置文件
 * @author zyang0419
 * @create 2016-10-25 上午9:01
 **/

/**

 * classpath路径：locations={"classpath:application-bean1.xml","classpath:application-bean2.xml"}

 * file路径： locations = {"file:d:/test/application-bean1.xml"};

 */

//@Configuration
//@ImportResource(locations={"classpath:application-bean.xml"})
//@ImportResource(locations={"file:d:/test/application-bean1.xml"})
public class XMLConfig {


}
