package com.springboot.camel.rest.springboot_camel_rest_base;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class InspectionBean {
    public void reviewData(Exchange exchange, @Body String body){
        int i = 0;
    }
}
