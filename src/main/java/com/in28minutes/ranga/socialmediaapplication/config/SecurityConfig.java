/*
package com.in28minutes.ranga.socialmediaapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails rootUser = User.builder()
                .username("Jpb")
                .password(passwordEncoder().encode("root"))
                .roles("ADMIN")
                .build();
        UserDetails dev = User.builder()
                .username("Barsha")
                .password(passwordEncoder().encode("dev123"))
                .roles("DEV")
                .build();
        return new InMemoryUserDetailsManager(rootUser,dev);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/
