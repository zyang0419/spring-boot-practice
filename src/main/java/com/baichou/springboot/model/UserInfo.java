package com.baichou.springboot.model;/**
 * Created by root on 16-10-25.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 用户信息
 *
 * @author zyang0419
 * @create 2016-10-25 下午1:39
 **/

/**
 * 3个实体类，UserInfo,SysRole,SysPermission,对应的是数据库的五张表：

 1表UserInfo、2表SysUserRole、3表SysRole、4表SysRolePermission、5表SysPermission

 这时候运行程序，就会自动建表，然后我们添加一些数据：

 INSERT INTO `sys_permission` VALUES ('1', '1', '用户管理', '0', '0/', 'userInfo:view', 'menu', 'userInfo/userList');

 INSERT INTO `sys_permission` VALUES ('2', '1', '用户添加', '1', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');

 INSERT INTO `sys_permission` VALUES ('3', '1', '用户删除', '1', '0/1', 'userInfo:del', 'button', 'userInfo/userDel');

 INSERT INTO `sys_role` VALUES ('1', '1', '管理员', 'admin');

 INSERT INTO `sys_role` VALUES ('2', '1', 'VIP会员', 'vip');

 INSERT INTO `sys_role_permission` VALUES ('1', '1');

 INSERT INTO `sys_role_permission` VALUES ('1', '2');

 INSERT INTO `sys_user_role` VALUES ('1', '1');

 INSERT INTO `sys_user_role` VALUES ('1', '2');

 INSERT INTO `user_info` VALUES ('1', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0','admin');

 */

@Entity
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long uid;//用户id;

    @Column(unique=true)
    private String username;//账号.

    private String name;//名称（昵称或者真实姓名，不同系统不同定义）

    private String password; //密码;

    private String salt;//加密密码的盐

    private int state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.


    @ManyToMany(fetch=FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色

    public List<SysRole> getRoleList() {
        return roleList;

    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;

    }

    public long getUid() {
        return uid;

    }

    public void setUid(long uid) {
        this.uid = uid;

    }

    public String getUsername() {
        return username;

    }

    public void setUsername(String username) {
        this.username = username;

    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getPassword() {
        return password;

    }

    public void setPassword(String password) {
        this.password = password;

    }


    public String getSalt() {
        return salt;

    }

    public void setSalt(String salt) {
        this.salt = salt;

    }

    public int getState() {
        return state;

    }

    public void setState(int state) {
        this.state = state;

    }

    /**
     * 密码盐.
     * @return
     */

    public String getCredentialsSalt(){
        return this.username+this.salt;

    }



    @Override
    public String toString() {
        return "UserInfo [uid=" + uid + ", username=" + username + ", name=" + name + ", password=" + password

                + ", salt=" + salt + ", state=" + state + "]";

    }





}
