package com.springboot.camel.rest.springboot_camel_rest_base;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class Application implements CommandLineRunner /* extends SpringBootServletInitializer */{

    @Autowired
    CamelContext camelContext;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        camelContext.createProducerTemplate().requestBody("direct:start", (Object) null);
    }
}
