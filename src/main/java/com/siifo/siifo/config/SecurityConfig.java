package com.siifo.siifo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;



@Configuration
public class SecurityConfig {

    //Endopoint level autorization

    //---- Matcher
    //1. AnyRequest
    //2. RequestMatchers 
    //3. RequestMatchers with HttpMethod

    
    //----- Aurtorization rol
    //1. PermitAll
    //2. DenyAll
    //3. Authenticated





    
    //Filtros de SpringSecurity para manejar las peticiones
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
            .httpBasic()
            .and().authorizeHttpRequests()
            // .anyRequest().permitAll() //Da acceso a todos los usuarios (o no usuarios) con todos los permisos
            // .anyRequest().denyAll() // niega todos los permisos
            // .anyRequest().authenticated() //para cuqluier ususario que este atutenticado
            // .anyRequest().hasRole("ADMIN")
            // .anyRequest().hasAnyAuthority("Administrador")
            // .anyRequest().access( new WebExpressionAuthorizationManager("hasRole('ADMIN') or hasRole('USER')"))
            .requestMatchers("/").permitAll()
            .requestMatchers("/admin").access( new WebExpressionAuthorizationManager("hasRole('ADMIN') or hasRole('USER')"))
            .requestMatchers(HttpMethod.POST).hasAuthority("Administrador")
            .requestMatchers("/editar/delete").hasAuthority("Administrador")
            .requestMatchers(HttpMethod.GET).authenticated()
            .requestMatchers("/demo").hasRole("USER")
            .and().csrf().disable().build();
    }
    
    //credenciales de usuario
    @Bean
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .authorities("Empleado", "ROLE_USER")
                .build(),
            User.withUsername("asd@gmail.com")
                .password(passwordEncoder().encode("password"))
                .authorities("Administrador", "ROLE_ADMIN")
                .build()
        );
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
