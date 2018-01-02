package com.springboot.camel.rest.springboot_camel_rest_base;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration()   //.contextPath("/camel-rest-jpa")
                 //.host("localhost").port("8088")
                .bindingMode(RestBindingMode.json);

        // http://localhost:8086/rest/sayhello/Nanto
//        rest("/sayhello/{msg}")
//                .get("/").to("bean:helloBean?method=greetingWorld(${header.msg})");

        // curl -X GET -H "msg:Nanto" http://localhost:8086/rest/sayhello/
        rest("/sayhello")
                .get("/").to("bean:helloBean?method=greetingWorld(${header.msg})"); //.log("${body}");

//                .get("/").description("The list of all the books")
//                .route().routeId("books-api")
//                .bean(HelloController.class, "greetingWorld(${header.msg})")
//                .endRest();
    }
}
