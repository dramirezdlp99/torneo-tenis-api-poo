package com.torneotenis.torneo_tenis.controller;

import com.torneotenis.torneo_tenis.model.Arbitro;
import com.torneotenis.torneo_tenis.model.dto.ArbitroDTO;
import com.torneotenis.torneo_tenis.service.IArbitroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/arbitros")
public class ArbitroController {

    private final IArbitroService arbitroService;

    public ArbitroController(IArbitroService arbitroService) {
        this.arbitroService = arbitroService;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ArbitroDTO dto) {
        try {
            return ResponseEntity.ok(arbitroService.crearArbitro(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Arbitro>> listar() {
        return ResponseEntity.ok(arbitroService.listarArbitros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(arbitroService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            arbitroService.eliminarArbitro(id);
            return ResponseEntity.ok("Árbitro eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}