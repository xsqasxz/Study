//package com.basics.service.impl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.access.AccessDecisionVoter;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.core.Authentication;
//
//import java.util.Collection;
//
///**
// * 用来控制是否可以访问地址
// * @author xueshiqi
// * @since 2019/5/10
// * AccessDecisionVoter是投票器，在授权的时通过投票的方式来决定用户是否可以访问，这里涉及到投票规则
// */
//public class MyAccessDecisionVoter implements AccessDecisionVoter {
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyAccessDecisionVoter.class);
//    @Override
//    public boolean supports(ConfigAttribute configAttribute) {
//        LOGGER.info(String.valueOf(configAttribute));
//        return false;
//    }
//
//    @Override
//    public int vote(Authentication authentication, Object o, Collection collection) {
//        LOGGER.info(String.valueOf(authentication));
//        LOGGER.info(String.valueOf(o));
//        LOGGER.info(String.valueOf(collection));
//        return 0;
//    }
//
//    @Override
//    public boolean supports(Class aClass) {
//        LOGGER.info(String.valueOf(aClass));
//        return false;
//    }
//}
