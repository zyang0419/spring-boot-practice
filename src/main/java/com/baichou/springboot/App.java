package com.baichou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */

//表示启用spring-boot默认配置　spring-boot根据pom中的依赖jar包进行默认配置。
// 其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，
// 等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
//SpringBoot项目的Bean装配默认规则是根据Application类所在的包位置从上往下扫描
//使用scanBasePackages属性进行指定要扫描的包以及要扫描的类
@SpringBootApplication(scanBasePackages = {
        "com.baichou",
        "org.help"
})
@RestController  //等价于@Controller 和 @ResponseBody
@ServletComponentScan//这个就是扫描相应的Servlet包;
public class App {

    /**
     * 默认静态资源映射
     * 其中默认配置的 /** 映射到 /static （或/public、/resources、/META-INF/resources）
     　其中默认配置的 /webjars/** 映射到 classpath:/META-INF/resources/webjars/
     　上面的 static、public、resources 等目录都在 classpath: 下面（如 src/main/resources/static）。
     *
     * 当我们访问地址 http://localhost:8080/test.jpg 的时候，显示哪张图片？
     * 这里可以直接告诉大家，优先级顺序为：META/resources > resources > static > public
     */

    //启用fastjson
    /*@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }*/

    public static void main(String[] args) {
//        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(App.class,args);


//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
//        SpringApplication app = new SpringApplication(App.class);
//        app.run(args);
//        SpringApplication.run("classpath:/META-INF/application-context.xml",args);

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
