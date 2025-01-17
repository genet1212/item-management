package com.backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("/all")
    public String allAccess(){
        return "Public Content.";
    }
    @GetMapping("/user")
    @PreAuthorize("hashRole('USER) or hashRole('MODERATOR') or hashRole('ADMIN')")
    public String userAccess(){
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hashRole('MODERATOR')")
    public String moderatorAccess(){
        return "Moderator Content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hashRole('ADMIN')")
    public String adminAccess(){
        return "Admin Content.";
    }

}
