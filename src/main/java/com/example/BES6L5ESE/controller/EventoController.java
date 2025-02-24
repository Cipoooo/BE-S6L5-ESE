package com.example.BES6L5ESE.controller;

import com.example.BES6L5ESE.entity.Evento;
import com.example.BES6L5ESE.entityDTO.EventoDTO;
import com.example.BES6L5ESE.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired EventoService eventoService;

    @PostMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public Evento createEvento(@RequestBody @Validated EventoDTO eventoDTO){
        return eventoService.createEvent(eventoDTO);
    }

    @GetMapping
    public List<Evento> getAllEvent(){
        return eventoService.getAllEvents();
    }


}
