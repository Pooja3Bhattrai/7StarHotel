package com.oyo.HotelManagement2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

// NOTE: THIS IS FOR AUTHORISATION CODE


    @Configuration
    @EnableWebSecurity
    public class SecurityConfigration {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable()).authorizeRequests((authorizeRequests) ->
                            authorizeRequests
                                    .requestMatchers("/hotel/").permitAll()
                                    .requestMatchers("/hotel/create",  "/room/create").hasRole("ADMIN")
                                    .requestMatchers("/room/id").hasRole("ADMIN")
                    )
                    .httpBasic(withDefaults());
            return http.build();
        }


        @Bean
       public UserDetailsService userDetailsService() {

           UserDetails user1 = User.builder().username("lipika").password(getEncoder().encode("lipika123")).roles("USER").build();
            UserDetails user2 = User.builder().username("pooja").password(getEncoder().encode("pooja123")).roles("ADMIN").build();
           UserDetails user3 = User.builder().username("Mayank").password("{noop}Mahakal123").roles("ADMIN").build();
            return new InMemoryUserDetailsManager(user1, user2, user3);

     }

        @Bean
       public PasswordEncoder getEncoder(){
            return new BCryptPasswordEncoder();
       }

        }