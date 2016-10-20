package com.baichou.springboot.controller;

import com.baichou.springboot.dao.UserDao;
import com.baichou.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

/**
 * Created by root on 16-10-20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/getByEmail/{email}")
    @ResponseBody
    public String getByEmail(@PathVariable String email) {
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        sw.start("query a user information by email.");
        String userId;
        User user = userDao.findByEmail(email);
        if (user != null) {
            userId = String.valueOf(user.getId());
            return "The user id is: " + userId;
        }
        sw.stop();
        System.err.println(sw.prettyPrint());
        return "user " + email + " is not exist.";
    }

    @RequestMapping("/addTest")
    @ResponseBody
    public String addTest() throws UnsupportedEncodingException {
        User user = new User("zhangsan@163.com","zhangsan");
        userDao.save(user);
        user = new User("lisi@163.com","lisi");
        userDao.save(user);

        user = new User("wangwu@163.com",new String("王五".getBytes(),"utf-8"));
        userDao.save(user);

        return "add user successed";
    }
}
