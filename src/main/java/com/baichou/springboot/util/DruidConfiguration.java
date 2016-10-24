package com.baichou.springboot.util;

/**
 * Created by root on 16-10-21.
 */

import org.springframework.context.annotation.Configuration;

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



}