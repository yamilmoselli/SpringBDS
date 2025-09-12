package com.springbds.SpringBDS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CustomerController {

    @GetMapping("/index1")
    public String index1() {
        return "with security";
    }

    @GetMapping("/index2")
    public String index2() {
        return "without security";
    }

}
