package com.baichou.springboot.config;/**
 * Created by root on 16-10-25.
 */

/**
 * ehcache配置类
 *
 * @author zyang0419
 * @create 2016-10-25 上午10:50
 **/
//@Configuration
//@EnableCaching//标注启动缓存.　　和RedisCacheConfig,ShiroConfiguration不可同时使用,CacheManager不唯一
public class EHCacheConfiguration {
    /**
     *  ehcache 主要的管理器
     * @param bean
     * @return
     */

   /* @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
        System.out.println("CacheConfiguration.ehCacheCacheManager()");
        return new EhCacheCacheManager(bean.getObject());

    }*/



    /*
       * 据shared与否的设置,
       * Spring分别通过CacheManager.create()
       * 或new CacheManager()方式来创建一个ehcache基地.
       * 也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
       */

    /*@Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        System.out.println("CacheConfiguration.ehCacheManagerFactoryBean()");
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
        cacheManagerFactoryBean.setConfigLocation (new ClassPathResource("config/ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;

    }*/
}
