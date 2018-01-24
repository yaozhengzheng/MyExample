/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.bean;

/**
 * description:.
 * author https://github.com/yaozhengzheng.
 */

public class User {
    private String id;
    private String name;

    public User() {
        super();
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
