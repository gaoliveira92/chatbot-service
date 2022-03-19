package com.hmv.chatbotservice.application.config.security

import com.hmv.chatbotservice.application.config.EnvironmentConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder

@EnableWebSecurity
@Configuration
class WebSecurityConfig (
       val environmentConfig: EnvironmentConfig
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity){
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser(environmentConfig.user)
                .password("{noop}${environmentConfig.password}")
                .roles(environmentConfig.role)
    }

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                "/**.html",
                "/health-check",
                "/health-check/**",
                "/swagger-resources",
                "/swagger-resources/**"
        )
    }
}