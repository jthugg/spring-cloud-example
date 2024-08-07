package com.github.jthugg.spring.cloud.example.gateway.reactive.route.function;

import com.github.jthugg.spring.cloud.example.gateway.reactive.route.properties.RouteProperties;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

public class PingRouteFunction implements RouteFunction {

    @Override
    public Buildable<Route> apply(PredicateSpec predicateSpec) {
        return predicateSpec.path(RouteProperties.PING.getPath())
                .uri(RouteProperties.PING.getLoadBalancedUri());
    }

}
