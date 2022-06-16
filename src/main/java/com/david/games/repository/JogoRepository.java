package com.david.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.games.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {
    
}