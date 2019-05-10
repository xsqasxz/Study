package com.basics.service.impl;

import com.basics.entity.SysUser;
import com.basics.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xueshiqi
 * @since 2019/3/29
 * UserDetailsService是用于加载特定用户信息的，它只有一个接口通过指定的用户名去查询用户
 */
@Service
public class SysUserService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserService.class);
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 这里需要将角色可操作的资源进行加载
     * @param name
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        LOGGER.info("当前登录用户名称："+name);
        SysUser user = sysUserMapper.getSysUserByUserName(name);
        if(user == null){
            LOGGER.info("获取用户名失败："+name);
            throw new UsernameNotFoundException("用户名："+name+"不存在");
        }
        LOGGER.info(String.valueOf(user));
        //校验用户密码
        //查到User后将其封装为UserDetails的实现类的实例供程序调用
        //用该User和它对应的Role实体们构造UserDetails的实现类
//        return new UserDetailsImpl(user, roleService.getRolesOfUser(user.getUsername()));
        return user;
    }
}
