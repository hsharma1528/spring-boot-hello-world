package com.techsights.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTests {

    @Autowired
    private MockMvc mockMvc;

// The @Test annotation marks this method as a test case that should be run by the JUnit testing framework.
    // This method tests the sayHello() method in the HelloWorldController to ensure it returns "Hello, World!".
    @Test
    public void sayHello_ShouldReturnHelloWorld() throws Exception {
        // The mockMvc.perform() method is used to simulate an HTTP GET request to the /api/hello endpoint.
        // The get() method is a static import from MockMvcRequestBuilders and represents the HTTP GET request.
        mockMvc.perform(get("/api/hello"))
                // The andExpect() method is used to define expectations for the response.
                // Here, we expect the HTTP status to be 200 OK.
                .andExpect(status().isOk()) // Verifies that the response status is 200 OK
                // We also expect the response body to contain the string "Hello, World!".
                .andExpect(content().string("Hello, World")); // Verifies that the response body is "Hello, World!"
    }

    // This test method verifies the sayHelloTo() method in the HelloWorldController.
    // It checks that the method returns a personalized greeting based on the name provided in the URL.
    @Test
    public void sayHelloTo_ShouldReturnPersonalizedGreeting() throws Exception {
        String name = "John"; // This is the name we will pass as a path variable in the request

        // mockMvc.perform() is used again to simulate an HTTP GET request, this time to the /api/hello/{name} endpoint.
        // The {name} part of the URL is replaced with the value of the 'name' variable ("John").
        mockMvc.perform(get("/api/hello/" + name))
                // We expect the HTTP status to be 200 OK.
                .andExpect(status().isOk()) // Verifies that the response status is 200 OK
                // We expect the response body to contain the personalized greeting "Hello, John".
                .andExpect(content().string("Hello, " + name)); // Verifies that the response body is "Hello, John"
    }
}
