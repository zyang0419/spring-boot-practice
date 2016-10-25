package com.baichou.springboot.util;/**
 * Created by root on 16-10-25.
 */

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义acuator类
 *
 * HTTP方法    路径    描述                                                               鉴权
 * GET    /autoconfig 查看自动配置的使用情况，
 *                      该报告展示所有auto-configuration候选者及它们被应用或未被应用的原因     true
 * GET   /configprops   显示一个所有@ConfigurationProperties的整理列表                    true
 *
 *GET    /beans          显示一个应用中所有Spring Beans的完整列表                          true
 *GET    /dump            打印线程栈                                                    true
 *GET    /env            查看所有环境变量                                                true
 *GET   /env/{name}       查看具体变量值                                                true
  GET    /health           查看应用健康指标                                             false
 *
 * GET    /info              查看应用信息                                               false
   GET    /mappings         查看所有url映射                                              true
   GET     /metrics         查看应用基本指标                                             true
   GET  /metrics/{name}      查看具体指标                                                 true
  POST   /shutdown           允许应用以优雅的方式关闭（默认情况下不启用）                      true
  GET    /trace              查看基本追踪信息                                                true
 *
 * @author zyang0419
 * @create 2016-10-25 上午9:13
 **/
@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();

    }

    private int check() {

        return 0;
    }







}