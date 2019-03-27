package com.security;

import java.util.List;

/**
 * @author xueshiqi
 * @since 2019/3/18
 */
public class ListContainer {
    List<AClass> list;

    public List<AClass> getList() {
        return list;
    }

    public void setList(List<AClass> list) {
        this.list = list;
    }

    public ListContainer(List<AClass> list) {
        this.list = list;
    }
}
