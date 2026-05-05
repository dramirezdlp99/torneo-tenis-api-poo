package com.torneotenis.torneo_tenis.controller;

import com.torneotenis.torneo_tenis.model.Partido;
import com.torneotenis.torneo_tenis.model.dto.PartidoDTO;
import com.torneotenis.torneo_tenis.service.IPartidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private final IPartidoService partidoService;

    public PartidoController(IPartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PartidoDTO dto) {
        try {
            return ResponseEntity.ok(partidoService.crearPartido(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Partido>> listar() {
        return ResponseEntity.ok(partidoService.listarPartidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(partidoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/ganador")
    public ResponseEntity<?> registrarGanador(@PathVariable Integer id, @RequestParam Integer idGanador) {
        try {
            return ResponseEntity.ok(partidoService.registrarGanador(id, idGanador));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            partidoService.eliminarPartido(id);
            return ResponseEntity.ok("Partido eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}