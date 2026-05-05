package com.torneotenis.torneo_tenis.controller;

import com.torneotenis.torneo_tenis.model.Jugador;
import com.torneotenis.torneo_tenis.model.dto.JugadorDTO;
import com.torneotenis.torneo_tenis.service.IJugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private final IJugadorService jugadorService;

    public JugadorController(IJugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody JugadorDTO dto) {
        try {
            return ResponseEntity.ok(jugadorService.crearJugador(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> listar() {
        return ResponseEntity.ok(jugadorService.listarJugadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(jugadorService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/puntos")
    public ResponseEntity<?> actualizarPuntos(@PathVariable Integer id, @RequestParam Integer puntos) {
        try {
            return ResponseEntity.ok(jugadorService.actualizarPuntos(id, puntos));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            jugadorService.eliminarJugador(id);
            return ResponseEntity.ok("Jugador eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}