package com.torneotenis.torneo_tenis.repository;

import com.torneotenis.torneo_tenis.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
}