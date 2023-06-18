package com.learning.orderservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Component
public class WebClientConfig {

    @Value("${inventory-service.base.url}")
    private String BaseUrl;

    @Bean
    public WebClient  webClient(){
        return WebClient
                 .builder()
                 .build();
    }

}

