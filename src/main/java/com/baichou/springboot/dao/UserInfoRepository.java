package com.baichou.springboot.dao;/**
 * Created by root on 16-10-25.
 */

import com.baichou.springboot.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * userInfo持久化类
 *
 * @author zyang0419
 * @create 2016-10-25 下午2:25
 **/
public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);

}