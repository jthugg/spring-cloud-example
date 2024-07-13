package com.github.jthugg.spring.cloud.example.gateway.reactive.config;

import com.github.jthugg.spring.cloud.example.gateway.reactive.filter.PathRewriteFilter;
import com.github.jthugg.spring.cloud.example.gateway.reactive.filter.RequestTrackingFilter;
import com.github.jthugg.spring.cloud.example.gateway.reactive.filter.ReservedHeaderCheckFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalFilterConfig {

    @Bean
    public ReservedHeaderCheckFilter reservedHeaderCheckFilter() {
        return new ReservedHeaderCheckFilter();
    }

    @Bean
    public RequestTrackingFilter requestTrackingFilter() {
        return new RequestTrackingFilter();
    }

    @Bean
    public PathRewriteFilter pathRewriteFilter() {
        return new PathRewriteFilter();
    }

}
