package com.example.BES6L5ESE.entityDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

    private String nome;
    private String cognome;
    private String username;
    @NotBlank(message = "Necessario inserire una password")
    private String password;
    @NotBlank
    @Email(message = "Inserire una mail appropriata")
    private String mail;

}
