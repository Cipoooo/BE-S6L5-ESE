package com.example.BES6L5ESE.controller;

import com.example.BES6L5ESE.entity.Evento;
import com.example.BES6L5ESE.entity.Prenotazione;
import com.example.BES6L5ESE.entityDTO.EventoDTO;
import com.example.BES6L5ESE.entityDTO.PrenotazioneDTO;
import com.example.BES6L5ESE.service.EventoService;
import com.example.BES6L5ESE.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired PrenotazioneService prenotazioneService;

//    @PostMapping("/new")
//    @PreAuthorize("hasRole('USER')")
//    public Prenotazione createPrenotazione(@RequestBody @Validated PrenotazioneDTO prenotazioneDTO){
//        return prenotazioneService.createPrenotazione(prenotazioneDTO);
//    }

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni (){
        return prenotazioneService.getAllPrenotazioni();
    }
}

