package com.github.jthugg.spring.cloud.example.gateway.reactive.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;

public interface GlobalGatewayFilter extends GlobalFilter, Ordered {

    @Override
    default int getOrder() {
        return 0;
    }

}
