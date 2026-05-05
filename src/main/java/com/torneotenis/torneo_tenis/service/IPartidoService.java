package com.torneotenis.torneo_tenis.service;

import com.torneotenis.torneo_tenis.model.Partido;
import com.torneotenis.torneo_tenis.model.dto.PartidoDTO;
import java.util.List;

public interface IPartidoService {
    Partido crearPartido(PartidoDTO dto);
    Partido registrarGanador(Integer idPartido, Integer idGanador);
    List<Partido> listarPartidos();
    Partido buscarPorId(Integer id);
    void eliminarPartido(Integer id);
}