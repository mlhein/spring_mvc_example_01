package com.example.spring_mvc_example_01.Security;

import com.example.spring_mvc_example_01.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.csrf().disable();
        // http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/addperson").hasAnyAuthority("ADMIN")
                .antMatchers("/logout").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated();
        http.logout();
        // .logoutUrl("/logout");
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.inMemoryAuthentication()
    // .withUser("admon").password(passwordEncoder().encode("123")).roles("ADMIN")
    // .and()
    // .withUser("user").password(passwordEncoder().encode("123")).roles("USER");
    // }

}
