package org.help.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *  启动时输出打印信息
 *  SpringBoot项目的Bean装配默认规则是根据Application类所在的包位置从上往下扫描
 *  使用@ComponentScan注解进行指定要扫描的包以及要扫描的类
 * Created by root on 16-10-20.
 */
@Component
@Order(value=1)
public class MyCommandLineRunner implements CommandLineRunner {


    @Override
    public void run(String... strings) throws Exception {
        System.out.println();
        System.out.println("×××××××××××××××××××××××××××××××MyCommandLineRunner.run()××××××××××××××××××××××××××");
        System.out.println();

    }
}
