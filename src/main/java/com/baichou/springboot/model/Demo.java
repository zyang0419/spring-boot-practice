package com.baichou.springboot.model;

public class Demo {
    /**
     *
     *
     * Spring Boot引用了JSON解析包Jackson，
     * 那么自然我们就可以在Demo对象上使用Jackson提供的json属性的注解，对时间进行格式化，对一些字段进行忽略等等
     *
     *
     *
     */
    private long id;//主键.
    private String name;//测试名称.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}