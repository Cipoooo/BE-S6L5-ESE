package com.example.BES6L5ESE.repository;

import com.example.BES6L5ESE.entity.ERuolo;
import com.example.BES6L5ESE.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo,Long> {

    Optional<Ruolo> findByName(ERuolo nome);

}
