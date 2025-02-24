package com.example.BES6L5ESE.repository;

import com.example.BES6L5ESE.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {
}
