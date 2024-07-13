package com.github.jthugg.spring.cloud.example.gateway.reactive.filter;

import com.github.jthugg.spring.cloud.example.core.XHttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class ReservedHeaderCheckFilter implements GlobalGatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        for (String header : XHttpHeaders.HEADERS) {
            if (headers.containsKey(header)) {
                // TODO: Exception handling point
                throw new RuntimeException("Header [" + header + "] not allowed.");
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

}
