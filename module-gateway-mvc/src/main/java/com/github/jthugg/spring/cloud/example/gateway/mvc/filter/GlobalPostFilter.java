package com.github.jthugg.spring.cloud.example.gateway.mvc.filter;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.function.BiFunction;

public interface GlobalPostFilter
        extends BiFunction<ServerRequest, ServerResponse, ServerResponse>, Ordered, Comparable<GlobalPostFilter> {

    @Override
    default int compareTo(GlobalPostFilter filter) {
        if (getOrder() == filter.getOrder()) {
            return getClass().getCanonicalName().compareTo(filter.getClass().getCanonicalName());
        }
        return Integer.compare(getOrder(), filter.getOrder());
    }

    @Override
    default int getOrder() {
        return 0;
    }

}
