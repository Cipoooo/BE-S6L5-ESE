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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String username;
    private String mail;
    private String password;

    @OneToMany
    private List<Prenotazione> prenotazioneList;
    @OneToMany
    private List<Evento> eventoList;
    @ManyToOne
    private Ruolo ruolo;

}
