package com.baichou.springboot.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


/**
 * Created by root on 16-10-20.
 */
@Entity
@Table(name = "t_user")
public class User {
    // ==============
    // PRIVATE FIELDS
    // ==============
    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    // The user email
    @NotNull
    private String email;
    // The user name
    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @Column(name = "modification_time")
    private LocalDateTime modificationTime;

    @Column(name = "title",  length = 100)
    private String title;

    @Version
    private long version;

    public  User(){}

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public User(String email, String name, LocalDateTime modificationTime, String title, long version) {
        this.email = email;
        this.name = name;
        this.modificationTime = modificationTime;
        this.title = title;
        this.version = version;
    }

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(LocalDateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
