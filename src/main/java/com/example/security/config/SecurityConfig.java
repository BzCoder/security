package com.example.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

/**
 * @author BaoZhou
 * @date 2018/6/21
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*匹配所有路径的*/
        http.authorizeRequests().antMatchers("/").permitAll()
                /*level1路径下需要VIP1身份才能访问*/
                .antMatchers("/level1/**").hasRole("VIP1")
                /*level1路径下需要VIP2身份才能访问*/
                .antMatchers("/level2/**").hasRole("VIP2")
                /*level1路径下需要VIP3身份才能访问*/
                .antMatchers("/level3/**").hasRole("VIP3");

        /*
        1.formLogin系统会自动配置/login页面用于登录
        2.假如登录失败会重定向到login/error/
         */
        http.formLogin();
        /*开启注销功能,访问/logout并清空session*/
        http.logout();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

                auth
                /*从内存中读取认证*/
                .inMemoryAuthentication()
                /*Spring Security 5.0开始必须要设置加密方式*/
//                .passwordEncoder(new BCryptPasswordEncoder())
                        .passwordEncoder(new LdapShaPasswordEncoder())
                .withUser("user1").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1")
                .and()
                .withUser("user2").password(new BCryptPasswordEncoder().encode("123")).roles("VIP2")
                .and()
                .withUser("user3").password(new BCryptPasswordEncoder().encode("123")).roles("VIP3");
    }
}
