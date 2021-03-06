package com.server;

import com.server.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    CustomUserDetailsService customUserDetailsService;

    @Autowired
    SecurityConfig(CustomUserDetailsService customUserDetailsService){
        this.customUserDetailsService=customUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .httpBasic().and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/user/{id}").access("hasRole('ADMIN')")
                .antMatchers(HttpMethod.POST,"/api/user").permitAll()
                .antMatchers("/api/przesylka").access("hasRole('KLIENT')")
                .antMatchers("/api/typ").permitAll()
                .antMatchers("/api/pracowniksortowni").permitAll()
                .antMatchers("/api/kurier").permitAll()
                .antMatchers("/api/rozmiar").permitAll()
                .anyRequest().authenticated();
    }
}
