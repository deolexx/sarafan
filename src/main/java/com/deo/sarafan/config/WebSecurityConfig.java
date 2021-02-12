package com.deo.sarafan.config;

import com.deo.sarafan.entity.User;
import com.deo.sarafan.repo.UserDetailsRepo;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers("/").
                permitAll().anyRequest().authenticated().and().csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor (UserDetailsRepo userDetailsRepo){
        return map -> {
            return new User();
        };
    }

}
