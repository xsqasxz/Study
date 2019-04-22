package com.basics.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Set;

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

    //与项目角色表一对多关系
    private Set<SysPermission> permissions;

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

    public Set<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<SysPermission> permissions) {
        this.permissions = permissions;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
