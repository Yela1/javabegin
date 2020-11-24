package ru.javabegin.lesson.bigproject.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { // класс для настройки безопасности приложения


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // временно отключаем безопаcность, чтобы не требовал ввода логина и пароля на страницах
        http.authorizeRequests()
                .antMatchers("/**").permitAll()

                .and()

                .csrf().disable();


    }
}