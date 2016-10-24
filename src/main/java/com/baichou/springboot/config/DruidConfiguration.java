package com.baichou.springboot.config;

/**
 * Created by root on 16-10-21.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**

 * druid 配置.
 * 这样的方式不需要添加注解：@ServletComponentScan
 * @author zyang0419

 *

 */

@Configuration
public class DruidConfiguration {



    /**
     * 注册一个StatViewServlet
     * @return
     */

   /* @Bean
    public ServletRegistrationBean DruidStatViewServle2(){

        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid2*//*");
        //添加初始化参数：initParams
        //白名单：
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny","192.168.1.73");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername","jin");
        servletRegistrationBean.addInitParameter("loginPassword","jin123");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;

    }
*/


    /**
     * 注册一个：filterRegistrationBean
     * @return
     */

  /*  @Bean
    public FilterRegistrationBean druidStatFilter2(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("*//*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2*//*");
        return filterRegistrationBean;
    }*/


    /*@Bean
    public DataSource druidDataSource(@Value("${spring.datasource.driverClassName}") String driver,

                                      @Value("${spring.datasource.url}") String url,

                                      @Value("${spring.datasource.username}") String username,

                                      @Value("${spring.datasource.password}") String password,

                                      @Value("${spring.datasource.maxActive}") int maxActive

    ) {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(maxActive);
        System.out.println("DruidConfiguration.druidDataSource(),url="+url+",username="+username+",password="+password);
        try {
            druidDataSource.setFilters("stat, wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return druidDataSource;

    }
*/
   /* @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }*/


   /* @Configuration
    @EnableTransactionManagement
    public class DataBaseConfiguration implements EnvironmentAware {

        private RelaxedPropertyResolver propertyResolver;

        @Override
        public void setEnvironment(Environment env) {
            this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
        }

        @Bean(destroyMethod = "close", initMethod = "init")
        public DataSource writeDataSource() {
            System.out.println("注入druid！！！");


            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl(propertyResolver.getProperty("url"));
            dataSource.setUsername(propertyResolver.getProperty("username"));//用户名
            dataSource.setPassword(propertyResolver.getProperty("password"));//密码
            dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
            dataSource.setInitialSize(2);
            dataSource.setMaxActive(20);
            dataSource.setMinIdle(0);
            dataSource.setMaxWait(60000);
            dataSource.setValidationQuery("SELECT 1");
            dataSource.setTestOnBorrow(false);
            dataSource.setTestWhileIdle(true);
            dataSource.setPoolPreparedStatements(false);
            return dataSource;
        }

    }*/


    /**
     * Created by root on 16-10-24.
     */
    public static class Mongo {
    }

    /**
     * @ConditionOnClass表明该@Configuration仅仅在一定条件下才会被加载，这里的条件是Mongo.class位于类路径上
     · @EnableConfigurationProperties将Spring Boot的配置文件（application.properties）中的spring.data.mongodb.*
       属性映射为MongoProperties并注入到MongoAutoConfiguration中。
     · @ConditionalOnMissingBean说明Spring Boot仅仅在当前上下文中不存在Mongo对象时，才会实例化一个Bean。
       这个逻辑也体现了Spring Boot的另外一个特性——自定义的Bean优先于框架的默认配置，
       我们如果显式的在业务代码中定义了一个Mongo对象，那么Spring Boot就不再创建。
     * Created by root on 16-10-24.
     */
    @Configuration
    @ConditionalOnClass(Mongo.class)
    @EnableConfigurationProperties(MongoProperties.class)
    public static class MongoAutoConfiguration {
        @Autowired
        private MongoProperties properties;

    }

    @ConfigurationProperties(prefix = "spring.data.mongodb")
    public static class MongoProperties {


        private String host;
        private int port = 27017;
        private String uri = "mongodb://localhost/test";
        private String database;

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }


    }

    /**
     * Created by zyang0419 on 16-10-24.
     */
    @Configuration

    public static class MyEnvironmentAware implements EnvironmentAware {



        //注入application.properties的属性到指定变量中.
        @Value("${spring.datasource.url}")
        private String myUrl;



        /**
         *注意重写的方法 setEnvironment 是在系统启动的时候被执行。
         */

        @Override

        public void setEnvironment(Environment environment) {

            //打印注入的属性信息.
            System.out.println("myUrl="+myUrl);

            //通过 environment 获取到系统属性.
            System.out.println(environment.getProperty("JAVA_HOME"));

            //通过 environment 同样能获取到application.properties配置的属性.
            System.out.println(environment.getProperty("spring.datasource.url"));

            //获取到前缀是"spring.datasource." 的属性列表值.
            RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
            System.out.println("spring.datasource.url="+relaxedPropertyResolver.getProperty("url"));
            System.out.println("spring.datasource.driverClassName="+relaxedPropertyResolver.getProperty("driverClassName"));

        }

    }
}