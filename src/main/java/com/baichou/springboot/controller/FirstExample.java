package com.baichou.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
  
/** 
 * Created by zkn on 2016/8/7. 
 * 
 * @desc <ul> 
 * <li> 
 * @RestController注解相当于@Controller和@ResponseBody注解的结合。 
 * @ResponseBody注解：异步请求或者不需要返回页面的注解。 </li> 
 * <li> 
 * @RestController和@RequestMapping是SpringMVC的注解。 </li> 
 * <li> 
 * @EnableAutoConfiguration注解：这个注解是自动配置的注解。 我们把main方法的类放在最底层。 
 * </li> 
 * </ul> 
 * @see @{@link org.springframework.stereotype.Controller} 
 * @see @{@link org.springframework.web.bind.annotation.ResponseBody} 
 */  
@RestController  
//@EnableAutoConfiguration
public class FirstExample {  
  
    @RequestMapping("/first")
    String first() {
        return "Hello World！世界你好！O(∩_∩)O哈哈~！！！";  
    }  
  

}  