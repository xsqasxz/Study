package com.basics.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 访问控制方法
 * @author xueshiqi
 * @since 2019/4/3
 * AccessDecisionManager是用于访问控制的，它决定用户是否可以访问某个资源，实现这个接口可以定制我们自己的授权逻辑
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyAccessDecisionManager.class);
    // decide 方法是判定是否拥有权限的决策方法，
    //authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
    //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    //configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        LOGGER.info(String.valueOf(authentication));
        LOGGER.info(String.valueOf(collection));
        if(CollectionUtils.isEmpty(collection)) {
            return;
        }
        collection.stream().forEach(configAttribute -> {
            authentication.getAuthorities().stream().forEach(a->{
                if(configAttribute.getAttribute().equals(((GrantedAuthority) a).getAuthority()))
                    return;
            });
        });
        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        LOGGER.info(String.valueOf(configAttribute));
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        LOGGER.info(String.valueOf(aClass));
        return true;
    }
}
