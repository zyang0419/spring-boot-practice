package com.baichou.springboot.service;/**
 * Created by root on 16-10-25.
 */

import com.baichou.springboot.model.UserInfo;

/**
 * userInfo服务接口
 *
 * @author zyang0419
 * @create 2016-10-25 下午2:26
 **/
public interface UserInfoService {

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
