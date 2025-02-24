package com.example.BES6L5ESE.entityDTO.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUp {

    private String nome;
    private String cognome;

    @NotBlank(message = "Username è obbligatorio")
    private String username;
    @NotBlank(message = "Password è obbligatoria")
    private String password;
    @NotBlank(message = "E-mail obbligatoria")
    private String mail;

    private String ruolo;
}
