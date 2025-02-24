package com.example.BES6L5ESE.service;

import com.example.BES6L5ESE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;


    public CustomUserDetailService(UserRepository userRepository) {
         this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.BES6L5ESE.entity.User user = userRepository.findyBYUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>()
                // Collections.singletonList(new SimpleGrantedAuthority(user.getRuolo().getName()))
        );
    }

}
