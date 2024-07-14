package com.github.jthugg.spring.cloud.example.gateway.mvc.filter;

import com.github.jthugg.spring.cloud.example.core.XHttpHeaders;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

public class ResponseLabelingFilter implements GlobalPostFilter {

    @Override
    public ServerResponse apply(ServerRequest request, ServerResponse serverResponse) {
        serverResponse.headers().add(
                XHttpHeaders.X_REQUEST_ID,
                request.headers().firstHeader(XHttpHeaders.X_REQUEST_ID)
        );
        return serverResponse;
    }

}
