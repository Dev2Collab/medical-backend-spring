package com.hema.medical_backend_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .permitAll())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/customLogin", "/signup","/css/**", "/js/**", "/images/**", "/fonts/**","/","/contact","/about",
                                "/svgs/**", "/style.css", "/responsive.css", "/WEB-INF/views/**","/home")
                        .permitAll()
                        .anyRequest().authenticated())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true"))
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    // @Bean
    // UserDetailsService userDetailsService(){
    // UserDetails
    // user1=User.withUsername("hema").password("{noop}12345").authorities("read").build();
    // UserDetails
    // user2=User.withUsername("admin").password("{noop}12345").authorities("admin").build();

    // return new InMemoryUserDetailsManager(user1,user2);
    // }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
