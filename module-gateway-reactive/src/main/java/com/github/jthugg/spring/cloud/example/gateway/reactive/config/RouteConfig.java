package com.github.jthugg.spring.cloud.example.gateway.reactive.config;

import com.github.jthugg.spring.cloud.example.gateway.reactive.route.function.CheckRouteFunction;
import com.github.jthugg.spring.cloud.example.gateway.reactive.route.function.PingRouteFunction;
import com.github.jthugg.spring.cloud.example.gateway.reactive.route.properties.RouteProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(RouteProperties.PING.getService(), new PingRouteFunction())
                .route(RouteProperties.CHECK.getService(), new CheckRouteFunction())
                // TODO: Route more services point
                .build();
    }

}
