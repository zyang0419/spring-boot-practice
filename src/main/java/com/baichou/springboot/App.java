package com.baichou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */

//表示启用spring-boot默认配置　spring-boot根据pom中的依赖jar包进行默认配置。
// 其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，
// 等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
@SpringBootApplication
@RestController  //等价于@Controller 和 @ResponseBody
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    //修改端口
    //方法一 public class App implements EmbeddedServletContainerCustomizer
    /*@Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(80);
    }*/

    //方法二　
    /*@Bean
    public EmbeddedServletContainerFactory servletFactory(){
        TomcatEmbeddedServletContainerFactory tomcatFactory =
                new TomcatEmbeddedServletContainerFactory();
        tomcatFactory.setPort(8011);
        tomcatFactory.setSessionTimeout(10, TimeUnit.SECONDS);
        return tomcatFactory;

    }*/

    /**
     * 方法三
     *修改applicatoin.properties文件，在配置文件中加入：
     server.port=9090
     *
     */



    /**
     * 运行应用：mvn spring-boot:run或在IDE中运行main()方法，
     * 在浏览器中访问http://localhost:8080，Hello World!就出现在了页面中。
     */
    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }


}
