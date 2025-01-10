//package com.backend.controller;
//
//import com.backend.dtoes.*;
//import com.backend.repository.UserRepository;
//import com.backend.service.AuthenticationService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
//public class AuthenticationController {
//
//    private final AuthenticationService authenticationService;
//    UserRepository userRepository;
//
//    @PostMapping("/register")
//    public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest request) {
//        MessageResponse authRes = authenticationService.register(request);
////         RegisterResponse response = new RegisterResponse(
////                 authRes.getUserName(),
////                 authRes.getEmail(),
////                 authRes.getRoles()
////         );
//        return ResponseEntity.ok(authRes);
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//        System.out.println("Request: " + request.getPassword() + request.getUserName());
//        return ResponseEntity.ok(authenticationService.authenticate(request));
//    }
//
//}
//
//
//
//
//
