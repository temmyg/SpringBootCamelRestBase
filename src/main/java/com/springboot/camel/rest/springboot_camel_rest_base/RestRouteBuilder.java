package com.springboot.camel.rest.springboot_camel_rest_base;

import com.springboot.camel.rest.springboot_camel_rest_base.model.ClubMember;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
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
        from("direct:start").to("sql:select * from healthmember?outputType=selectlist")
//                .process(
//                new Processor() {
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        int i = 0;
//                    }
//                }
//        )
        .to("bean:sqlResultBean?method=processData");

        rest("/clubmembers")
                .get("/").to("bean:clubBean?method=getAllMembers")
                .post("/").type(ClubMember.class)
                .to("bean:clubBean?method=addClubMember(${body}, ${header.msg})"); //.log("${body}");
                //.to("bean:clubBean?method=addClubMember");

//                .get("/").description("The list of all the books")
//                .route().routeId("books-api")
//                .bean(HealthClubController.class, "greetingWorld(${header.msg})")
//                .endRest();
    }
}
