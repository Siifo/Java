package com.siifo.siifo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class configServer {
    //administra las credenciales del usuario
    
     // @Bean
    // public UserDetailsService userDetailsService(){

    //     var user = User.withUsername("admin")
    //     .password("12345").roles("read").build();
        
    //     return new InMemoryUserDetailsManager(user);
    // }
    
    // @Bean
    // public PasswordEncoder passwordEncoder(){
    //     return NoOpPasswordEncoder.getInstance();
    // }
}
