package com.demo.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.Controller.LoginController;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLoginValid() throws Exception {
        String jsonBody = "{\"username\": \"siddiqshaikh1@nimapinfotech.com\", \"password\": \"admin@123\"}";

        mockMvc.perform(post("/api/login")
                .contentType("application/json")
                .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Login successful"));
    }

    @Test
    public void testLoginInvalid() throws Exception {
        String jsonBody = "{\"username\": \"wronguser@nimapinfotech.com\", \"password\": \"wrongpassword\"}";

        mockMvc.perform(post("/api/login")
                .contentType("application/json")
                .content(jsonBody))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Invalid credentials"));
    }
}
