package com.example.BES6L5ESE.controller;

import com.example.BES6L5ESE.entity.User;
import com.example.BES6L5ESE.repository.UserRepository;
import com.example.BES6L5ESE.service.EventoService;
import com.example.BES6L5ESE.service.PrenotazioneService;
import com.example.BES6L5ESE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired EventoService eventoService;
    @Autowired PrenotazioneService prenotazioneService;

@PostMapping("/utente")
    public String generaUser(@RequestBody User user){
    userService.saveUser(user);
    return "Utente creato con successo";
}
@GetMapping("/all")
    public List<User> prendiTuttiUser(@RequestParam String ruolo){
    if (!ruolo.equals("RUOLO_ADMIN")){
        return null;
    }
    return "Metodo";
}

}
