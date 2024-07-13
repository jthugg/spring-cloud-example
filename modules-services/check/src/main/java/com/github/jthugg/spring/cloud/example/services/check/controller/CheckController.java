package com.github.jthugg.spring.cloud.example.services.check.controller;

import com.github.jthugg.spring.cloud.example.services.check.route.RouteTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    @GetMapping({RouteTable.ROOT, RouteTable.PUBLIC, RouteTable.ANONYMOUS, RouteTable.AUTHENTICATED})
    public String check() {
        return "check";
    }

}
