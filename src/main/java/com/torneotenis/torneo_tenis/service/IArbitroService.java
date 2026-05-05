package com.torneotenis.torneo_tenis.service;

import com.torneotenis.torneo_tenis.model.Arbitro;
import com.torneotenis.torneo_tenis.model.dto.ArbitroDTO;
import java.util.List;

public interface IArbitroService {
    Arbitro crearArbitro(ArbitroDTO dto);
    List<Arbitro> listarArbitros();
    Arbitro buscarPorId(Integer id);
    void eliminarArbitro(Integer id);
}