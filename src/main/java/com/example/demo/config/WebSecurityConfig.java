package com.example.demo.config;

import javax.management.AttributeChangeNotificationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import com.example.demo.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);
        http.requestCache((cache) -> cache
        .requestCache(requestCache));

        // http
        // .authorizeRequests()
        //     .requestMatchers("/login").permitAll()
        //     .anyRequest().authenticated()
        //     ;
        http.authorizeHttpRequests((auth) -> auth
        .requestMatchers("/login").permitAll()
        .requestMatchers("/login/error").permitAll()
        .requestMatchers("/usr/**").hasAuthority("USER")
        //.requestMatchers("/mng/**").hasAuthority("MANAGER")
        //.hasAnyRole("USER")
        .anyRequest().denyAll());

        // http.authorizeHttpRequests((authorize) -> authorize
        // .requestMatchers("/usr").hasRole("USER"));
    http
        .formLogin()
        .loginPage("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .failureUrl("/login/error")
            .defaultSuccessUrl("/usr/demo", true)
            // .and()
            // .formLogin()
            // .loginPage("/mnglogin")
            // .usernameParameter("username")
            // .passwordParameter("password")
            // .defaultSuccessUrl("/mng/demo", true)
            // .and()
            // .logout()
            // .logoutSuccessUrl("/logout");
            ;
		return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(userDetailServiceImpl, userDetailServiceImpl);
    } 
}
