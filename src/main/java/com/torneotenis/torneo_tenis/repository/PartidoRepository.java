package com.torneotenis.torneo_tenis.repository;

import com.torneotenis.torneo_tenis.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}