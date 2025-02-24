package com.example.BES6L5ESE.service;

import com.example.BES6L5ESE.entity.User;
import com.example.BES6L5ESE.entityDTO.UserDTO;
import com.example.BES6L5ESE.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired UserRepository userRepository;

    public User toEntity(UserDTO userDTO){
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setCognome(userDTO.getCognome());
        user.setUsername(userDTO.getUsername());
        user.setMail(userDTO.getMail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setCognome(user.getCognome());
        userDTO.setUsername(user.getUsername());
        userDTO.setMail(user.getMail());
        return userDTO;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User saveUserDTO(UserDTO userDTO){
        User user = toEntity(userDTO);
        return saveUser(user);
    }

}
