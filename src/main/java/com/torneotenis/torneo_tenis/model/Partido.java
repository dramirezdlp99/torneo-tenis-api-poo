package com.torneotenis.torneo_tenis.model;

import com.torneotenis.torneo_tenis.model.enums.EstadoPartido;
import com.torneotenis.torneo_tenis.model.enums.Ronda;
import jakarta.persistence.*;

@Entity
@Table(name = "partidos")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String resultado;
    private Integer duracionMinutos;

    @Enumerated(EnumType.STRING)
    private Ronda ronda;

    @Enumerated(EnumType.STRING)
    private EstadoPartido estado;

    @ManyToOne
    @JoinColumn(name = "id_torneo")
    private Torneo torneo;

    @ManyToOne
    @JoinColumn(name = "id_jugador1")
    private Jugador jugador1;

    @ManyToOne
    @JoinColumn(name = "id_jugador2")
    private Jugador jugador2;

    @ManyToOne
    @JoinColumn(name = "id_arbitro")
    private Arbitro arbitro;

    @ManyToOne
    @JoinColumn(name = "id_ganador")
    private Jugador ganador;

    public Partido() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public Integer getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(Integer duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public Ronda getRonda() { return ronda; }
    public void setRonda(Ronda ronda) { this.ronda = ronda; }
    public EstadoPartido getEstado() { return estado; }
    public void setEstado(EstadoPartido estado) { this.estado = estado; }
    public Torneo getTorneo() { return torneo; }
    public void setTorneo(Torneo torneo) { this.torneo = torneo; }
    public Jugador getJugador1() { return jugador1; }
    public void setJugador1(Jugador jugador1) { this.jugador1 = jugador1; }
    public Jugador getJugador2() { return jugador2; }
    public void setJugador2(Jugador jugador2) { this.jugador2 = jugador2; }
    public Arbitro getArbitro() { return arbitro; }
    public void setArbitro(Arbitro arbitro) { this.arbitro = arbitro; }
    public Jugador getGanador() { return ganador; }
    public void setGanador(Jugador ganador) { this.ganador = ganador; }
}