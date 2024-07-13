package com.github.jthugg.spring.cloud.example.gateway.reactive.route.properties;

public enum RouteProperties {

    PING(
            "ping-server",
            "/ping/**",
            "lb://ping-server"
    ),
    CHECK(
            "check-server",
            "/check/**",
            "lb://check-server"
    ),
    ;

    private final String service;
    private final String path;
    private final String loadBalancedUri;

    RouteProperties(String service, String path, String loadBalancedUri) {
        this.service = service;
        this.path = path;
        this.loadBalancedUri = loadBalancedUri;
    }

    public String getService() {
        return service;
    }

    public String getPath() {
        return path;
    }

    public String getLoadBalancedUri() {
        return loadBalancedUri;
    }

}
