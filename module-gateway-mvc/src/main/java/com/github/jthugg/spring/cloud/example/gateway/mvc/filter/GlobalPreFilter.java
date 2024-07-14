package com.github.jthugg.spring.cloud.example.gateway.mvc.filter;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.function.Function;

public interface GlobalPreFilter
        extends Function<ServerRequest, ServerRequest>, Ordered, Comparable<GlobalPreFilter> {

    @Override
    default int compareTo(GlobalPreFilter filter) {
        if (filter.getOrder() == getOrder()) {
            return filter.getClass().getCanonicalName().compareTo(getClass().getCanonicalName());
        }
        return Integer.compare(filter.getOrder(), getOrder());
    }

    @Override
    default int getOrder() {
        return 0;
    }

}
