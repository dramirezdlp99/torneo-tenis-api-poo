package com.torneotenis.torneo_tenis.service;

import com.torneotenis.torneo_tenis.model.Torneo;
import com.torneotenis.torneo_tenis.model.dto.TorneoDTO;
import com.torneotenis.torneo_tenis.repository.TorneoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TorneoService implements ITorneoService {

    private final TorneoRepository torneoRepository;

    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }

    public Torneo crearTorneo(TorneoDTO dto) {
        Torneo t = new Torneo();
        t.setNombre(dto.getNombre());
        t.setCiudad(dto.getCiudad());
        t.setPais(dto.getPais());
        t.setFechaInicio(dto.getFechaInicio());
        t.setFechaFin(dto.getFechaFin());
        t.setPremioTotal(dto.getPremioTotal());
        t.setSuperficie(dto.getSuperficie());
        t.setCategoria(dto.getCategoria());
        return torneoRepository.save(t);
    }

    public List<Torneo> listarTorneos() {
        return torneoRepository.findAll();
    }

    public Torneo buscarPorId(Integer id) {
        return torneoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneo no encontrado con id: " + id));
    }

    public void eliminarTorneo(Integer id) {
        buscarPorId(id);
        torneoRepository.deleteById(id);
    }

    public Integer calcularPremioCategoria(Integer id) {
        Torneo t = buscarPorId(id);
        return switch (t.getCategoria()) {
            case GRAND_SLAM -> t.getPremioTotal();
            case MASTERS_1000 -> (int)(t.getPremioTotal() * 0.75);
            case ATP_500 -> (int)(t.getPremioTotal() * 0.50);
            case ATP_250 -> (int)(t.getPremioTotal() * 0.25);
        };
    }
}