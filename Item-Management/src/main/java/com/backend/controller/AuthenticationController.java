package com.backend.controller;

import com.backend.dtoes.*;
import com.backend.model.User;
import com.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest request)
    {
        MessageResponse authRes =  service.register(request);
//         RegisterResponse response = new RegisterResponse(
//                 authRes.getUserName(),
//                 authRes.getEmail(),
//                 authRes.getRoles()
//         );
         return ResponseEntity.ok(authRes);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
    {
        System.out.println("Request: " + request.getPassword() + request.getUserName());
        return ResponseEntity.ok(service.authenticate(request));
    }
}
