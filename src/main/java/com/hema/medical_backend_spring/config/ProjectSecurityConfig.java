package com.hema.medical_backend_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request->request.requestMatchers("/login","/error","welcome").permitAll().anyRequest().authenticated())
        .formLogin(flc->flc.disable())
        .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean 
    UserDetailsService userDetailsService(){
        UserDetails user1=User.withUsername("hema").password("{noop}12345").authorities("read").build();
        UserDetails user2=User.withUsername("admin").password("{noop}12345").authorities("admin").build();

        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean 
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
