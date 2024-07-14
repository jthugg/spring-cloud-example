package com.github.jthugg.spring.cloud.example.gateway.mvc.config;

import com.github.jthugg.spring.cloud.example.gateway.mvc.filter.GlobalPostFilter;
import com.github.jthugg.spring.cloud.example.gateway.mvc.filter.GlobalPreFilter;
import com.github.jthugg.spring.cloud.example.gateway.mvc.properties.RouteProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

@Configuration
public class RouteConfig {

    private final List<GlobalPreFilter> globalPreFilters;
    private final List<GlobalPostFilter> globalPostFilters;

    @Autowired
    public RouteConfig(List<GlobalPreFilter> globalPreFilters, List<GlobalPostFilter> globalPostFilters) {
        this.globalPreFilters = globalPreFilters;
        this.globalPostFilters = globalPostFilters;
    }

    @Bean
    public RouterFunction<ServerResponse> pingServiceRouterFunction() {
        return buildRouters(RouteProperties.PING_SERVER);
    }

    @Bean
    public RouterFunction<ServerResponse> checkServiceRouterFunction() {
        return buildRouters(RouteProperties.CHECK_SERVER);
    }

    // Add more RouterFunction beans for route each services...

    private RouterFunction<ServerResponse> buildRouters(RouteProperties routeProperties) {
        return applyGlobalFilters(GatewayRouterFunctions
                .route(routeProperties.getServiceId())
                .route(RequestPredicates.path(routeProperties.getPathPattern()), HandlerFunctions.https())
                .filter(LoadBalancerFilterFunctions.lb(routeProperties.getServiceId())))
                .build();
    }

    private RouterFunctions.Builder applyGlobalFilters(RouterFunctions.Builder builder) {
        globalPreFilters.forEach(builder::before);
        globalPostFilters.forEach(builder::after);
        return builder;
    }

}
