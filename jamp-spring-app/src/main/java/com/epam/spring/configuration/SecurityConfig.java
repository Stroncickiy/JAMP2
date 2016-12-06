package com.epam.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.epam.spring.security.LogoutHandler;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("myUserDetailsService")
    UserDetailsService userDetailsService;
    @Autowired
	private LogoutHandler logoutHandler;
    @Autowired
    @Qualifier("customFailureHandler")
	private AuthenticationFailureHandler customFailureHandler;
    
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	   auth
           .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
   

    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .accessDeniedPage("/denied")
                .and()
                .formLogin()
                .loginPage("/login")
                .failureHandler(customFailureHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/").and().authorizeRequests()
                .and().authorizeRequests()
                .antMatchers("/phases/add").hasAuthority("ADMIN")
                .and().authorizeRequests()
                .antMatchers("/login", "/resources/**", "/register")
                .permitAll().and().authorizeRequests()
                .anyRequest().authenticated().and().csrf().disable()
                .logout().logoutSuccessHandler(logoutHandler);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
}