package com.techsights.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class for handling hello world requests.
 */
/*
 * The @RestController annotation is a convenience annotation that combines @Controller and @ResponseBody.
   This annotation marks the class as a Spring MVC controller where each method returns a domain object
   instead of a view. The object data is directly written to the HTTP response as JSON or XML.
 */
@RestController
/* The @RequestMapping annotation is used to map web requests to specific handler classes and methods.
   Here, it maps requests that start with "/api" to methods in this controller. */
@RequestMapping("/api")
public class HelloWorldController {
    /* The @GetMapping annotation is a specialized version of @RequestMapping that is used to handle GET requests.
       It maps HTTP GET requests to the method sayHello().
    */
    @GetMapping("/hello")
    public String sayHello() {
        /*
         * This method returns a plain text response "Hello, World!".
         * In a RESTful web service, this response is automatically serialized into the HTTP response body.
         */
        return "Hello, World";
    }

    /*
     * The @GetMapping annotation here maps HTTP GET requests to the method sayHelloTo() with a path variable.
     * The URL pattern "/hello/{name}" indicates that the URL will contain a variable part (in this case, 'name').
     */
    @GetMapping("/hello/{name}")
    public String sayHelloTo(@PathVariable String name) {
        /*
         * The @PathVariable annotation binds the 'name' variable from the URL to the method parameter 'name'.
         * This allows you to capture dynamic values from the URL and use them in your method.
         * The method returns a personalized greeting using the captured 'name'.
         */
        return "Hello, " + name;
    }
    
}
