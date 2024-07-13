package com.github.jthugg.spring.cloud.example.gateway.reactive.filter;

import com.github.jthugg.spring.cloud.example.core.XHttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class RequestTrackingFilter implements GlobalGatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(buildLabeledExchange(exchange));
    }
    private ServerWebExchange buildLabeledExchange(ServerWebExchange exchange) {
        String requestId = UUID.randomUUID().toString();
        return exchange.mutate()
                .request(buildLabeledRequest(exchange.getRequest(), requestId))
                .response(buildLabeledResponse(exchange.getResponse(), requestId))
                .build();
    }

    private ServerHttpRequest buildLabeledRequest(ServerHttpRequest request, String requestId) {
        return request.mutate().header(XHttpHeaders.X_REQUEST_ID, requestId).build();
    }

    private ServerHttpResponse buildLabeledResponse(ServerHttpResponse response, String requestId) {
        response.getHeaders().set(XHttpHeaders.X_REQUEST_ID, requestId);
        return response;
    }

}
