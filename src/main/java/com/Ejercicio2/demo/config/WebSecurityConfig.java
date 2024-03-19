package com.Ejercicio2.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Ejercicio2.demo.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity //habilitar la configuracion web de la seguridad
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	//Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
    @Override
    protected void configure(HttpSecurity http) throws Exception { // en el config le decimos que asegure o que no y como queremos que lo asegure
        http 
            //le vamos a decir a http que vamos a configurar los Request para asi mismo definir quienes estan autorizados y quienes no y de que manera
            .authorizeRequests() 
            //acá le decimos que cualquiera puede acceder a los resourcesc(img, css, js, icons, etc..)
	        .antMatchers(resources).permitAll()  
            //aca le decimos que a la raiz o al index cualquiera puede entrar
	        .antMatchers("/","/index").permitAll() 
            // acá le decimos que todo lo que sea admin, tiene que tener el rol de ADMIN obligatorio
	        .antMatchers("/admin*").access("hasRole('ADMIN')") 
            // acá le decimos que todo lo que sea user, tiene que tener el rol de USER obligatorio
	        .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')") 
            //Aca le decimos que si quiere acceder a otro mapping un ejemplo /menu, tiene que estar debidamente autenticado sea el rol que sea.
                .anyRequest().authenticated() 
            //con este and decimos que queremos configurar otra parte
                .and()  
            //queremos configurar el formulario de login
            .formLogin() 
            //aca le pasamos el mapping del controller, es decir que el formulario se encuentra en /login
                .loginPage("/login") 
                // y aca que cualquiera puede acceder al login
                .permitAll() 
                //si el ususario se logea exitosamente nos llevara a la url menu
                .defaultSuccessUrl("/menu") 
                //por el contrario si no se logea exitosamente nos va a devolver a la url /login con el parametro error (recordar que el parametro error esta en el index.html)
                .failureUrl("/login?error=true") 
                //acá debemos especificar que  campos del formulario seran de parametro username y password (donde en el index tambien se encuentra en el name)
                .usernameParameter("username")
                .passwordParameter("password")
                //aca con el and vamos a configuar otra parte del security esta vez será del logout
                .and()
            .logout()
                //cualquiera se puede desloguear
                .permitAll()
                //despues de desloguearse nos llevara al /login con el parametro logout (vamos al index y miramos bien donde esta el logout)
                .logoutSuccessUrl("/login?logout");
    }

    //acá configuramos la encriptacion de las contraseñas
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        //este constructor del encriptador recibe un parametro de enteros
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    //El numero 4 representa que tan fuerte quieres la encriptacion.
    //Se puede en un rango entre 4 y 31. 
    //Si no ponemos un numero el programa utilizara uno aleatoriamente cada vez que iniciemos la aplicacion, por lo cual las contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }
	
    @Autowired
    //este es el servicio
    UserDetailsServiceImpl userDetailsService;

    //en la configuracion global y de la manera en como vamos a autenticar los usuarios va a ser utilizando el coder (linea 87) y un servicio
	
    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());   
    }
}