package com.github.jthugg.spring.cloud.example.gateway.reactive.route.function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

import java.util.function.Function;

public interface RouteFunction extends Function<PredicateSpec, Buildable<Route>> {
}
