package com.example.BES6L5ESE.service;

import com.example.BES6L5ESE.entity.Evento;
import com.example.BES6L5ESE.entity.Prenotazione;
import com.example.BES6L5ESE.entity.User;
import com.example.BES6L5ESE.repository.EventoRepository;
import com.example.BES6L5ESE.repository.PrenotazioneRepository;
import com.example.BES6L5ESE.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PrenotazioneService {

    @Autowired EventoRepository eventoRepository;
    @Autowired PrenotazioneRepository prenotazioneRepository;
    @Autowired UserRepository userRepository;

    public String prenotazioneEvento(Long eventoId,String username){

        User user = userRepository.findyBYUsername(username).orElseThrow(()->new RuntimeException("No User found"));
        Evento evento = eventoRepository.findById(eventoId).orElseThrow(()->new RuntimeException("No Event found"));

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUser(user);
        prenotazione.setEvento(evento);
        prenotazioneRepository.save(prenotazione);
        user.getPrenotazioneList().add(prenotazione);
        return "Tutto ok";
    }
}
