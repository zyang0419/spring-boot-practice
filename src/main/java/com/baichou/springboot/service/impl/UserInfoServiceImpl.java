package com.baichou.springboot.service.impl;/**
 * Created by root on 16-10-25.
 */

import com.baichou.springboot.dao.UserInfoRepository;
import com.baichou.springboot.model.UserInfo;
import com.baichou.springboot.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * userInfo数据处理类
 *
 * @author zyang0419
 * @create 2016-10-25 下午2:27
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Resource
    private UserInfoRepository userInfoRepository;



    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);

    }



}