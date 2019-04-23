package com.basics.config;

import com.basics.entity.SysUser;
import com.basics.mapper.SysUserMapper;
import com.basics.service.impl.MyFilterSecurityInterceptor;
import com.basics.service.impl.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author xueshiqi
 * @since 2019/4/3
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 密码匹配校验
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                //对密码进行加密处理
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String password) {
                //校验密码是否相等
                return password.equals(charSequence.toString());
            }
        });
        //不删除凭据，以便记住用户
        auth.eraseCredentials(false);
    }
    public void configure(WebSecurity web) throws Exception {
        //需要忽略的访问地址
        web.ignoring().antMatchers("/resources/**");
    }

    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
        //        // http.authorizeRequests()每个匹配器按照它们被声明的顺序被考虑。
        http
                .authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "**/favicon.ico").permitAll()
                // ROLE_USER的权限才能访问的资源
                .antMatchers("/user/**").hasRole("USER")
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 指定登录页面,授予所有用户访问登录页面
                .loginPage("/login")
                //设置默认登录成功跳转页面,错误回到login界面
                .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
                .and()
                //开启cookie保存用户数据
                .rememberMe()
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                //设置cookie的私钥
                .key("security")
                .and()
                .logout()
                .permitAll();
        //登录拦截器
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
//                //springsecurity4自动开启csrf(跨站请求伪造)与restful冲突
                .csrf().disable();
    }
}
