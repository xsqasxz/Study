package com.basics.entity;

/**
 * @author xueshiqi
 * @since 2019/3/29
 * 用户权限表
 */
public class SysPermission {
    //用户权限表id
    private int id;
    //用户权限名称
    private String name;
    //用户权限描述
    private String descritpion;
    //授权url
    private String url;
    //用户权限表父id
    private int pid;

    public SysPermission() {
    }

    public SysPermission(String name, String descritpion, String url, int pid) {
        this.name = name;
        this.descritpion = descritpion;
        this.url = url;
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descritpion='" + descritpion + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
