package net.project.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DbConfig {
    
    @Profile("dev")
    @Bean
    public void dataSourceDb(){

    }
}
