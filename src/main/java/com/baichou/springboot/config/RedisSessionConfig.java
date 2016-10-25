package com.baichou.springboot.config;/**
 * Created by root on 16-10-25.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 使用redis保持多个app的session一致
 *  所有实体类实现Serializable接口
 public class UserInfo implements Serializable
 *
 * @author zyang0419
 * @create 2016-10-25 上午11:27
 **/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600) //10分钟失效
public class RedisSessionConfig {

}
