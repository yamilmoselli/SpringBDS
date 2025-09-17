package com.springbds.SpringBDS.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/hello-permit")
    @PreAuthorize("permitAll()")
    public String index() {
        return "Hello World permit all";
    }

    @GetMapping("/hello-secured")
    @PreAuthorize("hasAnyAuthority('CREATE')")
    public String index2() {
        return "Hello World secured";
    }

    @GetMapping("/hello-notsecured")
    public String index3() {
        return "Hello world deny all";
    }
}
