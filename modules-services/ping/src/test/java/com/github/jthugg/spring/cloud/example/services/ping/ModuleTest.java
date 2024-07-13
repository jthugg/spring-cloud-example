package com.github.jthugg.spring.cloud.example.services.ping;

import com.github.jthugg.spring.cloud.example.services.ping.route.RouteTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class ModuleTest {

    MockMvc mvc;
    RequestBuilder rootPath;
    RequestBuilder publicPath;
    RequestBuilder anonymousPath;
    RequestBuilder authenticatedPath;
    String resultString;

    @Autowired
    ModuleTest(MockMvc mvc) {
        this.mvc = mvc;
        this.rootPath = MockMvcRequestBuilders.get(RouteTable.ROOT);
        this.publicPath = MockMvcRequestBuilders.get(RouteTable.PUBLIC);
        this.anonymousPath = MockMvcRequestBuilders.get(RouteTable.ANONYMOUS);
        this.authenticatedPath = MockMvcRequestBuilders.get(RouteTable.AUTHENTICATED);
        this.resultString = "check";
    }

    @Test
    void rootPathTest() throws Exception {
        mvc.perform(rootPath)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(resultString))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void publicPathTest() throws Exception {
        mvc.perform(publicPath)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(resultString))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void anonymousPathTest() throws Exception {
        mvc.perform(anonymousPath)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(resultString))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void authenticatedPathTest() throws Exception {
        mvc.perform(authenticatedPath)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(resultString))
                .andDo(MockMvcResultHandlers.print());
    }

}
