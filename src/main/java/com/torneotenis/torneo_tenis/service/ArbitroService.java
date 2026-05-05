package com.torneotenis.torneo_tenis.service;

import com.torneotenis.torneo_tenis.model.Arbitro;
import com.torneotenis.torneo_tenis.model.dto.ArbitroDTO;
import com.torneotenis.torneo_tenis.repository.ArbitroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArbitroService implements IArbitroService {

    private final ArbitroRepository arbitroRepository;

    public ArbitroService(ArbitroRepository arbitroRepository) {
        this.arbitroRepository = arbitroRepository;
    }

    public Arbitro crearArbitro(ArbitroDTO dto) {
        Arbitro a = new Arbitro();
        a.setNombre(dto.getNombre());
        a.setApellido(dto.getApellido());
        a.setNacionalidad(dto.getNacionalidad());
        a.setCorreo(dto.getCorreo());
        a.setLicencia(dto.getLicencia());
        a.setAniosExperiencia(dto.getAniosExperiencia());
        return arbitroRepository.save(a);
    }

    public List<Arbitro> listarArbitros() {
        return arbitroRepository.findAll();
    }

    public Arbitro buscarPorId(Integer id) {
        return arbitroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Árbitro no encontrado con id: " + id));
    }

    public void eliminarArbitro(Integer id) {
        buscarPorId(id);
        arbitroRepository.deleteById(id);
    }
}