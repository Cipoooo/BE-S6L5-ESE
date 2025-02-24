package com.example.BES6L5ESE.entityDTO;

import com.example.BES6L5ESE.entity.Evento;
import com.example.BES6L5ESE.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrenotazioneDTO {

    @NotBlank(message = "L' Utente è obbligatorio")
    private User user;
    @NotBlank(message = "L' Evento è obbligatorio")
    private Evento evento;
}
