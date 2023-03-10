package com.azhar.LoginSystem.config;

import com.azhar.LoginSystem.exception.security.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/register", "/api/**").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().authorizeRequests()
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/user").hasRole("USER")
                    .antMatchers("/register", "/api/**", "/login").permitAll()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                .and().httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService (DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
}
