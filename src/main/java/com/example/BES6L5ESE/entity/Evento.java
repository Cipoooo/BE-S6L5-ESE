package com.example.BES6L5ESE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titoloEvento;
    private String descrizioneEvento;
    private Boolean disponibilità;
    private  String location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User eventoManager;

    @OneToMany
    private List<Prenotazione> prenotazioneList;
}
