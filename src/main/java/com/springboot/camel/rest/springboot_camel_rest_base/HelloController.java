package com.springboot.camel.rest.springboot_camel_rest_base;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component("helloBean")
public class HelloController {

    public String greetingWorld(String msg){
        return "Hello " + msg;
    }
}
