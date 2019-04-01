package com.basics.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author xueshiqi
 * @since 2019/3/29
 * 用户角色表
 */
public class SysRole implements GrantedAuthority {
    //用户角色表id
    private Integer id;
    //用户角色名称
    private String name;

    public SysRole() {
    }

    public SysRole(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
