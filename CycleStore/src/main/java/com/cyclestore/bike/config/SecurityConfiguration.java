package com.cyclestore.bike.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        JwtWebSecurityConfigurer.forRS256(apiAudience, issuer)
//                .configure(http)
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/v1/bikes").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/v1/bikes").hasAuthority("view.registrations")
//                .antMatchers(HttpMethod.GET, "/api/v1/bikes/**").hasAuthority("view.registration")
//                .anyRequest().authenticated();
//    }
}
