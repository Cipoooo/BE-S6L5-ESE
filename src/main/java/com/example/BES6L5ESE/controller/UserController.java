package com.example.BES6L5ESE.controller;

import com.example.BES6L5ESE.entity.User;
import com.example.BES6L5ESE.entityDTO.UserDTO;
import com.example.BES6L5ESE.entityDTO.request.SignUp;
import com.example.BES6L5ESE.repository.UserRepository;
import com.example.BES6L5ESE.service.AuthService;
import com.example.BES6L5ESE.service.EventoService;
import com.example.BES6L5ESE.service.PrenotazioneService;
import com.example.BES6L5ESE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired EventoService eventoService;
    @Autowired PrenotazioneService prenotazioneService;
    @Autowired private AuthService authService;

    @PostMapping("/new")
    public String generaUser(@RequestBody User user){
    userService.saveUser(user);
    return "Utente creato con successo";
   }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody @Validated UserDTO userDTO) {
        User user = userService.saveUserDTO(userDTO);
        return userService.toDTO(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated SignUp signUp) {
        return authService.authenticateUser(signUp);
    }
}
