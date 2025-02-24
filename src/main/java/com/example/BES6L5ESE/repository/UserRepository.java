package com.example.BES6L5ESE.repository;

import com.example.BES6L5ESE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findyBYUsername(String username);
    public boolean esisteUeP(String username, String password);

}
