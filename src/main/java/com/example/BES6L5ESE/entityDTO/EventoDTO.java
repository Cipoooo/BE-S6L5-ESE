package com.example.BES6L5ESE.entityDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EventoDTO {

    @NotBlank(message = "IL campo titolo è obbligatorio")
    private String titoloEvento;
    @NotBlank(message = "IL campo descrizione è obbligatorio")
    private String descrizioneEvento;
    @NotBlank(message = "IL campo disponbilità è obbligatorio")
    private Boolean disponibilita;
    @NotBlank(message = "IL campo location è obbligatorio")
    private  String location;

}
