package com.cyclestore.bike.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfiguration {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

    protected void Configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer.forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/bikes").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/bikes").hasAuthority("view.registrations")
                .antMatchers(HttpMethod.GET, "/api/v1/bikes/**").hasAuthority("view.registration")
                .anyRequest().authenticated();
    }
}
