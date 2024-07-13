package com.github.jthugg.spring.cloud.example.gateway.reactive.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class PathRewriteFilter implements GlobalGatewayFilter {

    private static final String REGEXP = "^/[^/]+(?<segment>)";
    private static final String REPLACEMENT = "/${segment}";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(rewrite(exchange));
    }

    private ServerWebExchange rewrite(ServerWebExchange exchange) {
        String path = exchange.getRequest().getURI().getPath();
        String replacedPath = path.replaceAll(REGEXP, REPLACEMENT);
        return exchange.mutate().request(exchange.getRequest().mutate().path(replacedPath).build()).build();
    }

}
