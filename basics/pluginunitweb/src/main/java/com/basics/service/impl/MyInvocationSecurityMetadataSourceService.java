//package com.basics.service.impl;
//
//import com.basics.entity.SysPermission;
//import com.basics.entity.SysRole;
//import com.basics.mapper.SysRoleMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import java.util.*;
//
//@Service
//public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
//
//    @Autowired
//    private SysRoleMapper sysRoleMapper;
//
//    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
//
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        FilterInvocation filterInvocation = (FilterInvocation) object;
//        if (resourceMap == null) {
//            loadResourceDefine();
//        }
//        Iterator<String> ite = resourceMap.keySet().iterator();
//        while (ite.hasNext()) {
//            String resURL = ite.next();
//            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
//            if (requestMatcher.matches(filterInvocation.getHttpRequest())) {
//                return resourceMap.get(resURL);
//            }
//        }
//
//        return null;
//    }
//
//    /**
//     * 加载权限表中所有权限
//     */
//    private void loadResourceDefine() {
//        //一定要加上@PostConstruct注解
//        // 在Web服务器启动时，提取系统中的所有权限。</span>
//        List<SysRole> list = sysRoleMapper.findAll();
//        /*
//         * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
//         * sparta
//         */
//        resourceMap = new HashMap<>();
//        if (!CollectionUtils.isEmpty(list)) {
//            list.stream().forEach(sysRole -> {
//                Set<SysPermission> sysPermissions = sysRole.getPermissions();
//                sysPermissions.stream().forEach(sysPermission -> {
//                    Collection<ConfigAttribute> atts;
//                    if (resourceMap.containsKey(sysPermission.getUrl())) {
//                        atts = resourceMap.get(sysPermission.getUrl());
//                    } else {
//                        atts = new ArrayList<>();
//                    }
//                    atts.add(new SecurityConfig(sysRole.getName()));
//                    resourceMap.put(sysPermission.getUrl(), atts);
//                });
//            });
//        }
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return true;
//    }
//}