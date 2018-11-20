package com.mockito.demo.entity;

public class User {
    private Long id;

    private String name;

    private Integer sex;

    public Long getId() {
        return id;
    }

    public User withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public User withSex(Integer sex) {
        this.setSex(sex);
        return this;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}