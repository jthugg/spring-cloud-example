package com.github.jthugg.spring.cloud.example.gateway.mvc.filter;

import com.github.jthugg.spring.cloud.example.core.XHttpHeaders;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.function.ServerRequest;

public class ReservedHeaderCheckFilter implements GlobalPreFilter {

    @Override
    public ServerRequest apply(ServerRequest request) {
        HttpHeaders headers = request.headers().asHttpHeaders();
        for (String header : XHttpHeaders.HEADERS) {
            if (headers.containsKey(header)) {
                // TODO: Exception handling point
                throw new RuntimeException("Header [" + header + "] not allowed.");
            }
        }
        return request;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

}
