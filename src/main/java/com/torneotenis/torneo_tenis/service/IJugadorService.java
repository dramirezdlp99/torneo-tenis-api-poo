package com.torneotenis.torneo_tenis.service;

import com.torneotenis.torneo_tenis.model.Jugador;
import com.torneotenis.torneo_tenis.model.dto.JugadorDTO;
import java.util.List;

public interface IJugadorService {
    Jugador crearJugador(JugadorDTO dto);
    List<Jugador> listarJugadores();
    Jugador buscarPorId(Integer id);
    Jugador actualizarPuntos(Integer id, Integer puntos);
    void eliminarJugador(Integer id);
}