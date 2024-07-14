package com.github.jthugg.spring.cloud.example.gateway.mvc.config;

import com.github.jthugg.spring.cloud.example.gateway.mvc.filter.PathRewriteFilter;
import com.github.jthugg.spring.cloud.example.gateway.mvc.filter.RequestTrackingFilter;
import com.github.jthugg.spring.cloud.example.gateway.mvc.filter.ReservedHeaderCheckFilter;
import com.github.jthugg.spring.cloud.example.gateway.mvc.filter.ResponseLabelingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalFilterConfig {

    @Bean
    public RequestTrackingFilter requestTrackingFilter() {
        return new RequestTrackingFilter();
    }

    @Bean
    public ReservedHeaderCheckFilter reservedHeaderCheckFilter() {
        return new ReservedHeaderCheckFilter();
    }

    @Bean
    public PathRewriteFilter pathRewriteFilter() {
        return new PathRewriteFilter();
    }

    @Bean
    public ResponseLabelingFilter responseLabelingFilter() {
        return new ResponseLabelingFilter();
    }

}
