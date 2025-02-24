package com.example.BES6L5ESE.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ruolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuolo;

    @Enumerated(EnumType.STRING)
    private ERuolo ruolo;

}
