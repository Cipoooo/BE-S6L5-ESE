package com.example.BES6L5ESE.entityDTO.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Response {

    private List<String> ruoliLIst;
    private String username;
    private Long id;
    private String mail;
    private String token;
    private String type = "Bearer";

    public Response(List<String> ruoliLIst, String username, Long id, String mail, String token) {
        this.ruoliLIst = ruoliLIst;
        this.username = username;
        this.id = id;
        this.mail = mail;
        this.token = token;
    }
}
