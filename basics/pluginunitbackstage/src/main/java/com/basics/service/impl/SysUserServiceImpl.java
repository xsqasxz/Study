package com.basics.service.impl;

import com.basics.mapper.SysUserMapper;
import com.basics.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xueshiqi
 * @since 2019/3/29
 */
@Service
public class SysUserServiceImpl extends SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
