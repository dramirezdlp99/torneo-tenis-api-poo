package com.torneotenis.torneo_tenis.repository;

import com.torneotenis.torneo_tenis.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
}