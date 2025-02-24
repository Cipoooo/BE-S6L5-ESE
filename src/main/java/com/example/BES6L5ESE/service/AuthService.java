package com.example.BES6L5ESE.service;

import com.example.BES6L5ESE.entityDTO.request.SignUp;
import com.example.BES6L5ESE.security.jwt.jwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final jwtUtils jwtUtils;

    public AuthService(AuthenticationManager authenticationManager, jwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public ResponseEntity<?> authenticateUser(SignUp signUp) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signUp.getUsername(),
                            signUp.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            Object principal = authentication.getPrincipal();
            String username;

            if (principal instanceof org.springframework.security.core.userdetails.User) {
                username = ((org.springframework.security.core.userdetails.User) principal).getUsername();
            } else {
                username = principal.toString();
            }



            username = ((UserDetails) authentication.getPrincipal()).getUsername();
            if (username == null || username.isEmpty()) {
                throw new RuntimeException("username is not valid!");
            }
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            String jwt = jwtUtils.generateToken(username, String.valueOf(roles));

            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The username or password is incorrect.!");
        }
    }
}

