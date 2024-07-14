package com.github.jthugg.spring.cloud.example.gateway.mvc.filter;

import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.web.servlet.function.ServerRequest;

public class PathRewriteFilter implements GlobalPreFilter {

    private static final String REGEXP = "^/[^/]+(?<segment>)";
    private static final String REPLACEMENT = "/${segment}";

    @Override
    public ServerRequest apply(ServerRequest request) {
        return BeforeFilterFunctions.rewritePath(REGEXP, REPLACEMENT).apply(request);
    }

}
