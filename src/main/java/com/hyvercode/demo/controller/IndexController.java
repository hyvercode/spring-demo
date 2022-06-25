package com.hyvercode.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    /**
     * Get methodes
     * @return
     */
    @GetMapping(value = "/greetings")
    public String greeting(){
        return "Hello Hyvercode";
    }

    /**
     * Post Methode
     * @return
     */
    @PostMapping(value = "/greeting")
    public String postGreeting(){
        return "www.hyvercode.com";
    }
}
