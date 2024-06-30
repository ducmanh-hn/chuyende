package com.tlu.chuyende.config;

import com.tlu.chuyende.model.Account;
import com.tlu.chuyende.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/login").permitAll()
                                .requestMatchers("/api/account/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/class/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/class-detail/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/lecturer/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/score/**").hasAnyAuthority("ADMIN","LECTURER")
                                .requestMatchers("/api/semester/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/student/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/subject/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
