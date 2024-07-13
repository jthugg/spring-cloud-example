package com.github.jthugg.spring.cloud.example.services.ping.controller;

import com.github.jthugg.spring.cloud.example.services.ping.route.RouteTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping({RouteTable.ROOT, RouteTable.PUBLIC, RouteTable.ANONYMOUS, RouteTable.AUTHENTICATED})
    public String pong() {
        return "pong";
    }

}
