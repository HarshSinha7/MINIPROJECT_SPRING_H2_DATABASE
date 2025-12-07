package com.practice.Config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilerChain(HttpSecurity http) throws Exception {
        http.csrf().ignoringRequestMatchers(PathRequest.toH2Console())
                .and().authorizeHttpRequests()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/signup").permitAll()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("/**").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();
        http.headers().frameOptions().disable();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("boss")
                .password("{noop}12345")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
