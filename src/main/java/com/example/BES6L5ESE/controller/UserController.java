package com.example.BES6L5ESE.controller;

import com.example.BES6L5ESE.repository.UserRepository;
import com.example.BES6L5ESE.service.EventoService;
import com.example.BES6L5ESE.service.PrenotazioneService;
import com.example.BES6L5ESE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired EventoService eventoService;
    @Autowired PrenotazioneService prenotazioneService;



}
