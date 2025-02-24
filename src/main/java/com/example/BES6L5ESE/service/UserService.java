package com.example.BES6L5ESE.service;

import com.example.BES6L5ESE.entity.User;
import com.example.BES6L5ESE.entityDTO.request.SignUp;
import com.example.BES6L5ESE.repository.RuoloRepository;
import com.example.BES6L5ESE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired UserRepository userRepository;
    @Autowired private RuoloRepository ruoloRepository;



}
