package com.torneotenis.torneo_tenis.service;

import com.torneotenis.torneo_tenis.model.Torneo;
import com.torneotenis.torneo_tenis.model.dto.TorneoDTO;
import java.util.List;

public interface ITorneoService {
    Torneo crearTorneo(TorneoDTO dto);
    List<Torneo> listarTorneos();
    Torneo buscarPorId(Integer id);
    void eliminarTorneo(Integer id);
    Integer calcularPremioCategoria(Integer id);
}