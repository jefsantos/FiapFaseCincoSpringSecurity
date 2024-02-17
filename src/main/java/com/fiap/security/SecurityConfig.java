package com.fiap.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http
	                .authorizeHttpRequests(
	                        authorizeConfig -> {
	                            authorizeConfig.requestMatchers(HttpMethod.POST, "/api/CadastrarNovoAparelho").permitAll();
	                            authorizeConfig.requestMatchers("/api/todosAparelhos").permitAll();
	                            authorizeConfig.requestMatchers("/api/aparelhoPorId").permitAll();

	                            authorizeConfig.anyRequest().authenticated();
	                        }).httpBasic(Customizer.withDefaults())
	                .build();
	    }
}
