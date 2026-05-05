package com.torneotenis.torneo_tenis.service;

import com.torneotenis.torneo_tenis.model.Jugador;
import com.torneotenis.torneo_tenis.model.dto.JugadorDTO;
import com.torneotenis.torneo_tenis.repository.JugadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JugadorService implements IJugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public Jugador crearJugador(JugadorDTO dto) {
        Jugador j = new Jugador();
        j.setNombre(dto.getNombre());
        j.setApellido(dto.getApellido());
        j.setNacionalidad(dto.getNacionalidad());
        j.setCorreo(dto.getCorreo());
        j.setRanking(dto.getRanking());
        j.setPuntosAcumulados(dto.getPuntosAcumulados());
        j.setTitulos(dto.getTitulos());
        return jugadorRepository.save(j);
    }

    public List<Jugador> listarJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador buscarPorId(Integer id) {
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado con id: " + id));
    }

    public Jugador actualizarPuntos(Integer id, Integer puntos) {
        Jugador j = buscarPorId(id);
        j.setPuntosAcumulados(j.getPuntosAcumulados() + puntos);
        return jugadorRepository.save(j);
    }

    public void eliminarJugador(Integer id) {
        buscarPorId(id);
        jugadorRepository.deleteById(id);
    }
}