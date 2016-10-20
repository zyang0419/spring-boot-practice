package com.baichou.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 16-10-19.
 */
//@SpringBootApplication
@RestController
public class Application {

    /*public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }*/
    @RequestMapping("/hello")
    public String hello(){
        return "hello my spring boot application";
    }

    @RequestMapping("/helloworld")
    public String helloworld(){
        return "hello world";
    }



    @RequestMapping("/users/{username}")
    public String userProfile(@PathVariable("username") String username) {
        return String.format("user %s", username);
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "Login Page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost() {
        return "Login Post Request";
    }
}
