package com.backend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
                  @NotNull HttpServletRequest request,
                  @NotNull HttpServletResponse response,
                  @NotNull FilterChain filterChain)
                  throws ServletException, IOException {
           final String authHeader = request.getHeader("Authorization");
           final String jwt;
           final String userEmail;
           if(authHeader == null || !authHeader.startsWith("Bearer ")){
               filterChain.doFilter(request, response);
               return;
           }
           jwt = authHeader.substring(7);
           userEmail = jwtService.extractUsername(jwt);  // todo extract the userEmail from JWT token
    }
}
