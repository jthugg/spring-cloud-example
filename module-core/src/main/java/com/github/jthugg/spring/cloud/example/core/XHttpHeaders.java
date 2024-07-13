package com.github.jthugg.spring.cloud.example.core;

public class XHttpHeaders {

    public static final String X_REQUEST_ID = "x-request-id";
    public static final String X_REQUEST_USER_ID = "x-request-user-id";
    public static final String X_REQUEST_USER_ROLE  = "x-request-user-role";

    public static final String[] HEADERS = {
            X_REQUEST_ID,
            X_REQUEST_USER_ID,
            X_REQUEST_USER_ROLE
    };

}
