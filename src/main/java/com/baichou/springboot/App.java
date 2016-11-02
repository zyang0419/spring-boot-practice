package com.baichou.springboot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baichou.springboot.config.LocalSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;

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
//@Import(value={SpringUtil.class}) //引入不在APP包以及子包中的类，或者未交给spring容器管理的类.或者通过@Bean注入
@EnableConfigurationProperties({LocalSettings.class})//注入自定义配置文件local.properties
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
   @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }

    //错误页面处理
  /*  @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error403Page = new ErrorPage(HttpStatus.TEMPORARY_REDIRECT, "/403.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

            container.addErrorPages(error401Page,error403Page, error404Page, error500Page);
        });
    }
*/
    @Bean
    public   EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
            }
        };
    }

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
     * 对上传文件进行限制
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("128MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("256MB");
        //Sets the directory location where files will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig();

    }


    /**
     * 运行应用：mvn spring-boot:run或在IDE中运行main()方法，
     * 在浏览器中访问http://localhost:8080，Hello World!就出现在了页面中。
     */
   /* @RequestMapping("/")
    public String index() {
        return "Welcome to Spring boot world!";
    }
*/

    /*@Bean
    public JedisPool jedisPool(@Value("${redis.host}") String host,
                               @Value("${redis.port}") int port) {
        return new JedisPool(host, port);
    }*/

    /**
     * 修改DispatcherServlet默认配置
     *
     */
 /*   @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.json");
        return registration;
    }
*/
}
