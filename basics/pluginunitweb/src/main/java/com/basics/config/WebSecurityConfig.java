package com.basics.config;

import com.basics.service.impl.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xueshiqi
 * @since 2019/4/3
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 密码匹配校验
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info(String.valueOf(auth));
        auth.userDetailsService(sysUserService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                //对密码进行加密处理
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String password) {
                //校验密码是否相等
                LOGGER.info("用户密码password："+password);
                LOGGER.info("用户密码charSequence："+charSequence);
                return password.equals(charSequence.toString());
            }
        });
    }

    /**
     * 配置忽略访问的资源
     *
     * @param web
     * @throws Exception
     */
    public void configure(WebSecurity web) throws Exception {
        LOGGER.info(String.valueOf(web));
        //需要忽略的访问地址
        web.ignoring().antMatchers("/assets/**");
    }

    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info(String.valueOf(http));
        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问
    }
}
