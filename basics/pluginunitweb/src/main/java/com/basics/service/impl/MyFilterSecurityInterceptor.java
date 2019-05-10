//package com.basics.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.SecurityMetadataSource;
//import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
//import org.springframework.security.access.intercept.InterceptorStatusToken;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import javax.servlet.*;
//
///**
// * @author xueshiqi
// * @since 2019/4/4
// */
//@Service
//public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{
//
//    @Autowired
//    private MyInvocationSecurityMetadataSourceService myInvocationSecurityMetadataSourceService;
//
//    @Autowired
//    public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager) {
//        super.setAccessDecisionManager(myAccessDecisionManager);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);
//        //fi里面有一个被拦截的url
//        //里面调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限
//        //再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
//        InterceptorStatusToken token = super.beforeInvocation(fi);
//        try {
//            //执行下一个拦截器
//            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
//        } finally {
//            super.afterInvocation(token, null);
//        }
//    }
//
//    @Override
//    public Class<?> getSecureObjectClass() {
//        return FilterInvocation.class;
//    }
//
//    @Override
//    public SecurityMetadataSource obtainSecurityMetadataSource() {
//        return this.myInvocationSecurityMetadataSourceService;
//    }
//}
