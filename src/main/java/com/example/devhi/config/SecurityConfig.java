package com.example.devhi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeHttpRequests(authorizeRequests ->
						authorizeRequests
								.requestMatchers("/", "/home", "/error").permitAll()
								.anyRequest().authenticated()
				)
				.oauth2Login(oauthLogin ->
						oauthLogin
								.loginPage("/login")
								.defaultSuccessUrl("/success")
								.failureUrl("/loginFailure")
				)
				.logout(logout -> logout.logoutSuccessUrl("/").permitAll());

		return httpSecurity.build();
	}

}
