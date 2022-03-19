package com.hmv.chatbotservice.application.config.security

import com.hmv.chatbotservice.application.config.EnvironmentConfig
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
class WebSecurityConfig (
       val environmentConfig: EnvironmentConfig
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity){
        http.csrf().disable().authorizeRequests().anyRequest().permitAll()
    }

    override fun userDetailsService(): UserDetailsService {
        val details = User.withDefaultPasswordEncoder()
                .username(environmentConfig.user)
                .password(environmentConfig.password)
                .roles("USER")
                .build()
        return InMemoryUserDetailsManager(details)
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