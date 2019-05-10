//package com.basics.service.impl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * 认证方法，用于实现AuthenticationProvider接口
// * @author xueshiqi
// * @since 2019/4/24
// * 接口是用于认证的，可以通过实现这个接口来定制我们自己的认证逻辑，它的实现类有很多，默认的是JaasAuthenticationProvider
// */
//public class MyAuthenticationProvider implements AuthenticationProvider {
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyAuthenticationProvider.class);
//
//    @Autowired
//    private SysUserService sysUserService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        LOGGER.info(String.valueOf(authentication));
//        return authentication;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        LOGGER.info(String.valueOf(aClass));
//        return true;
//    }
//}
