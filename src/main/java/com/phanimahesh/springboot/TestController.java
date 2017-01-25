package com.phanimahesh.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {


    @RequestMapping("/cardnumber/{number}")
    public String restTest(@PathVariable String number){

        if (number.length() == 16) {
            return "<html><h1>"+"The payment has been processed for "+"************"+number.substring(12,15)+"</h1></html>";

        } else {
            return "<html><h1>Invalid Card</h1></html>";
        }
    }
}
