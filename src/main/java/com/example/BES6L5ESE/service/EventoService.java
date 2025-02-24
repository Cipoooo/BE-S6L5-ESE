package com.example.BES6L5ESE.service;

import com.example.BES6L5ESE.entity.Evento;
import com.example.BES6L5ESE.entity.User;
import com.example.BES6L5ESE.entityDTO.EventoDTO;
import com.example.BES6L5ESE.repository.EventoRepository;
import com.example.BES6L5ESE.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class EventoService {

    @Autowired EventoRepository eventoRepository;
    @Autowired UserRepository userRepository;

    public String saveE(EventoDTO eventoDTO){
        User user = userRepository.findById(eventoDTO.getEventoManagerId()).orElseThrow(()->new RuntimeException("No MAnager found"));
        Evento eventoSave = toEntity(eventoDTO);
        eventoRepository.save(eventoSave);
        return "Operazione completata con successo";
    }

    public Evento toEntity(EventoDTO eventoDTO){
        Evento evento = new Evento();
        evento.setDescrizioneEvento(eventoDTO.getDescrizioneEvento());
        evento.setTitoloEvento(eventoDTO.getTitoloEvento());
        evento.setDisponibilità(eventoDTO.getDisponibilita());
        evento.setLocation(eventoDTO.getLocation());
        return evento;
    }

    public EventoDTO toDTO(Evento evento){
        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setDescrizioneEvento(evento.getDescrizioneEvento());
        eventoDTO.setTitoloEvento(evento.getTitoloEvento());
        eventoDTO.setLocation(evento.getLocation());
        return eventoDTO;
    }

    public Evento createEvent(EventoDTO eventoDTO){
        Optional<User> organizzatore = userRepository.findById(eventoDTO.getEventoManagerId());
        if(organizzatore.isEmpty()){
            throw new RuntimeException("Organizzatore non trovato");
        }
        Evento evento = toEntity(eventoDTO);
        return  eventoRepository.save(evento);
    }
}
