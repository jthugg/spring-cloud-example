package com.github.jthugg.spring.cloud.example.gateway.mvc.filter;

import com.github.jthugg.spring.cloud.example.core.XHttpHeaders;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.UUID;

public class RequestTrackingFilter implements GlobalPreFilter {

    @Override
    public ServerRequest apply(ServerRequest request) {
        return ServerRequest.from(request)
                .header(XHttpHeaders.X_REQUEST_ID, UUID.randomUUID().toString())
                .build();
    }

}
