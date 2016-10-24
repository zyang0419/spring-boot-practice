package com.baichou.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zyang0419 on 16-10-24.
 */
@ConfigurationProperties(prefix = "local",locations = "classpath:local.properties")
public class LocalSettings {

    private String name;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




}
