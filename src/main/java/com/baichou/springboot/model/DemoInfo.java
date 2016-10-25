package com.baichou.springboot.model;/**
 * Created by root on 16-10-25.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * demo测试类
 *
 * @author zyang0419
 * @create 2016-10-25 上午9:42
 **/
@Entity
@Table(name = "t_demoinfo")
public class DemoInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String pwd;

    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;

    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getPwd() {
        return pwd;

    }

    public void setPwd(String pwd) {
        this.pwd = pwd;

    }



    @Override
    public String toString() {
        return"DemoInfo [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";

    }

}