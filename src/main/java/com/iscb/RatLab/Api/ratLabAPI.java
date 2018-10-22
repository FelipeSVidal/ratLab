package com.iscb.RatLab.Api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ratLabAPI {


    @RequestMapping("/")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/list")
    public String hello(@RequestParam(value = "name", defaultValue = "hell") String s){
        return s;
    }
}
