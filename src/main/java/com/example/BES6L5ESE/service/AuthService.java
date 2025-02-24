package com.example.BES6L5ESE.service;

import com.example.BES6L5ESE.entityDTO.request.SignUp;
import com.example.BES6L5ESE.security.jwt.jwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final jwtUtils jwtUtils;

    public AuthService(AuthenticationManager authenticationManager, jwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public ResponseEntity<?> authenticateUser(SignUp signUp){
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(signUp.getUsername(),signUp.getPassword()));
        // prende l'oggetto autenticato e lo rendiamo sicuro.  ⬇️
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        String ruolo = authentication.getAuthorities().toString();
        String jwt = jwtUtils.generateToken(username,ruolo);
        return ResponseEntity.ok(jwt);
    }
}
