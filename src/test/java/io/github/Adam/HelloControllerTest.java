package io.github.Adam;

import io.github.Adam.controller.HelloController;
import io.github.Adam.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;


    @BeforeEach
    void setUp() {
        when(helloService.prepareGreeting("Adam", 1)).thenReturn("Hello, Adam!");
    }

    @Test
    void welcomeShouldReturnProperGreeting() throws Exception {
        mockMvc.perform(get("/api")
                        .param("lang", "1")
                        .param("name", "Adam"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Adam!"));
        verify(helloService).prepareGreeting("Adam", 1);
    }
}
