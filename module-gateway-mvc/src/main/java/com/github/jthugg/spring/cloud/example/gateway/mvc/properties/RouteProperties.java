package com.github.jthugg.spring.cloud.example.gateway.mvc.properties;

public enum RouteProperties {

    PING_SERVER("ping-server", "/ping/**"),
    CHECK_SERVER("check-server", "/check/**"),
    ;

    private final String serviceId;
    private final String pathPattern;

    RouteProperties(String serviceId, String pathPattern) {
        this.serviceId = serviceId;
        this.pathPattern = pathPattern;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getPathPattern() {
        return pathPattern;
    }

}
