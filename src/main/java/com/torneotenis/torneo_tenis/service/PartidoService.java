package com.torneotenis.torneo_tenis.service;

import com.torneotenis.torneo_tenis.model.Partido;
import com.torneotenis.torneo_tenis.model.dto.PartidoDTO;
import com.torneotenis.torneo_tenis.model.enums.EstadoPartido;
import com.torneotenis.torneo_tenis.repository.PartidoRepository;
import com.torneotenis.torneo_tenis.service.strategy.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PartidoService implements IPartidoService {

    private final PartidoRepository partidoRepository;
    private final IJugadorService jugadorService;
    private final IArbitroService arbitroService;
    private final ITorneoService torneoService;

    public PartidoService(PartidoRepository partidoRepository,
                          IJugadorService jugadorService,
                          IArbitroService arbitroService,
                          ITorneoService torneoService) {
        this.partidoRepository = partidoRepository;
        this.jugadorService = jugadorService;
        this.arbitroService = arbitroService;
        this.torneoService = torneoService;
    }

    public Partido crearPartido(PartidoDTO dto) {
        if (dto.getIdJugador1().equals(dto.getIdJugador2())) {
            throw new RuntimeException("Un jugador no puede jugar contra sí mismo.");
        }

        Partido p = new Partido();
        p.setTorneo(torneoService.buscarPorId(dto.getIdTorneo()));
        p.setJugador1(jugadorService.buscarPorId(dto.getIdJugador1()));
        p.setJugador2(jugadorService.buscarPorId(dto.getIdJugador2()));
        p.setArbitro(arbitroService.buscarPorId(dto.getIdArbitro()));
        p.setRonda(dto.getRonda());
        p.setEstado(dto.getEstado());
        p.setResultado(dto.getResultado());
        p.setDuracionMinutos(dto.getDuracionMinutos());
        return partidoRepository.save(p);
    }

    public Partido registrarGanador(Integer idPartido, Integer idGanador) {
        Partido p = buscarPorId(idPartido);
        if (!idGanador.equals(p.getJugador1().getId()) &&
                !idGanador.equals(p.getJugador2().getId())) {
            throw new RuntimeException("El ganador debe ser uno de los dos jugadores del partido.");
        }

        p.setGanador(jugadorService.buscarPorId(idGanador));
        p.setEstado(EstadoPartido.FINALIZADO);

        EstrategiaPuntos estrategia = switch (p.getRonda()) {
            case FINAL -> new PuntosRondaFinal();
            case SEMIFINAL -> new PuntosRondaSemifinal();
            case CUARTOS -> new PuntosRondaCuartos();
            case OCTAVOS -> new PuntosRondaOctavos();
            case TERCERA -> new PuntosRondaTercera();
            case SEGUNDA -> new PuntosRondaSegunda();
            case PRIMERA -> new PuntosRondaPrimera();
        };

        int puntos = estrategia.calcularPuntos();
        jugadorService.actualizarPuntos(idGanador, puntos);
        return partidoRepository.save(p);
    }

    public List<Partido> listarPartidos() {
        return partidoRepository.findAll();
    }

    public Partido buscarPorId(Integer id) {
        return partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado con id: " + id));
    }

    public void eliminarPartido(Integer id) {
        buscarPorId(id);
        partidoRepository.deleteById(id);
    }
}