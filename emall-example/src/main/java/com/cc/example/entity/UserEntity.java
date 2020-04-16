package com.cc.example.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author YL.huang
 * @date 04/14/2020
 */
public class UserEntity {

    private Long id;
    private String name;

    public UserEntity() {
    }

    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
