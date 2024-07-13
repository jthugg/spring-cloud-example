package com.github.jthugg.spring.cloud.example.discovery.config;

import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaServer
public class EurekaClientConfig {

    @Bean
    public EurekaClientConfigBean eurekaClientConfigBean() {
        EurekaClientConfigBean config = new EurekaClientConfigBean();
        config.setRegisterWithEureka(false);
        config.setFetchRegistry(false);
        return config;
    }

}
