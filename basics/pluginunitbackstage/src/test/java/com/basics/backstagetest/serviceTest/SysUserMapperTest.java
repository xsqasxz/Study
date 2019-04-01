package com.basics.backstagetest.serviceTest;

import com.basics.entity.SysUser;
import com.basics.mapper.SysUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xueshiqi
 * @since 2019/3/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testInsert(){
        sysUserMapper.addSysUser(new SysUser("曹操","cc","ccpassword",true,true,true,true));
        sysUserMapper.addSysUser(new SysUser("乐进","yj","yjpassword",true,true,true,true));
        sysUserMapper.addSysUser(new SysUser("李典","ld","ldpassword",true,true,true,true));
        Assert.assertEquals(3,sysUserMapper.getAll().size());
//        List<String> usernameList = new ArrayList<>();
//        usernameList.add("cc");
//        usernameList.add("yj");
//        usernameList.add("ld");
//        sysUserMapper.deleteSysUserByUserName(usernameList);
    }

}
