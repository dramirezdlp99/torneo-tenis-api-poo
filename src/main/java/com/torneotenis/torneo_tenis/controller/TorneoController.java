package com.torneotenis.torneo_tenis.controller;

import com.torneotenis.torneo_tenis.model.Torneo;
import com.torneotenis.torneo_tenis.model.dto.TorneoDTO;
import com.torneotenis.torneo_tenis.service.ITorneoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/torneos")
public class TorneoController {

    private final ITorneoService torneoService;

    public TorneoController(ITorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody TorneoDTO dto) {
        try {
            return ResponseEntity.ok(torneoService.crearTorneo(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Torneo>> listar() {
        return ResponseEntity.ok(torneoService.listarTorneos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(torneoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/premio")
    public ResponseEntity<?> calcularPremio(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(torneoService.calcularPremioCategoria(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            torneoService.eliminarTorneo(id);
            return ResponseEntity.ok("Torneo eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}