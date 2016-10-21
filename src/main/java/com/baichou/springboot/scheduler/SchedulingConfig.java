package com.baichou.springboot.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务配置类
 *
 * @author root(11523884)
 * @create 2016年10月21日
 */
@Configuration
@EnableScheduling // 启用定时任务
public class SchedulingConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "0/50 * * * * ?") // 每50秒执行一次
    public void scheduler() {
        logger.info(">>>>>>>>>>>>> scheduled ... ");
    }

}