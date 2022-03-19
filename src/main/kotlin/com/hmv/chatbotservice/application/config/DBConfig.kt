package com.hmv.chatbotservice.application.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
        basePackages = arrayOf("com.hmv.chatbotservice.resource.repository"),
        entityManagerFactoryRef = "postgresEntityManager"
)
@EntityScan("com.hmv.chatbotservice.resource.repository.entity.*")
class DBConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    fun postgresDataSource():DataSource{
        return DataSourceBuilder.create().build()
    }

    @Bean
    @Primary
    fun postgresEntityManager(
            builder: EntityManagerFactoryBuilder,
            @Qualifier("postgresDataSource") dataSource: DataSource
    ):LocalContainerEntityManagerFactoryBean {
        return builder
                .dataSource(dataSource)
                .packages("com.hmv.chatbotservice.resource.repository.entity")
                .build()
    }
}