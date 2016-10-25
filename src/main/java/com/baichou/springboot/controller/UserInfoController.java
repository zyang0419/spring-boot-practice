package com.baichou.springboot.controller;/**
 * Created by root on 16-10-25.
 */

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * userInfo控制器类
 *
 * @author zyang0419
 * @create 2016-10-25 下午2:42
 **/


@Controller
@RequestMapping("/userInfo")
public class UserInfoController {


    /**
     * 用户查询.
     * @return
     */

    @RequestMapping("/userList")
    public String userInfo(){
        return "userInfo";

    }

    /**
     * 用户添加;
     * @return
     */

    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";

    }

    /**
     * 用户删除;
     * @return
     */

    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";

    }

}