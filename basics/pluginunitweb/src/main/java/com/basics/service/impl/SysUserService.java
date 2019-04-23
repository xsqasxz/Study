package com.basics.service.impl;

import com.basics.config.WebSecurityConfig;
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
 *
 */
@Service
public class SysUserService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserService.class);
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        LOGGER.info("当前登录用户名称："+name);
        SysUser user = sysUserMapper.getSysUserByUserName(name);
        if(user == null){
            LOGGER.info("获取用户名失败："+name);
            throw new UsernameNotFoundException("用户名："+name+"不存在");
        }
        //校验用户密码
        return user;
    }
}
