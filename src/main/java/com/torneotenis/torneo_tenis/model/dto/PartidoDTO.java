package com.torneotenis.torneo_tenis.model.dto;

import com.torneotenis.torneo_tenis.model.enums.EstadoPartido;
import com.torneotenis.torneo_tenis.model.enums.Ronda;

public class PartidoDTO {

    private Integer idTorneo;
    private Integer idJugador1;
    private Integer idJugador2;
    private Integer idArbitro;
    private Integer idGanador;
    private String resultado;
    private Integer duracionMinutos;
    private Ronda ronda;
    private EstadoPartido estado;

    public Integer getIdTorneo() { return idTorneo; }
    public void setIdTorneo(Integer idTorneo) { this.idTorneo = idTorneo; }
    public Integer getIdJugador1() { return idJugador1; }
    public void setIdJugador1(Integer idJugador1) { this.idJugador1 = idJugador1; }
    public Integer getIdJugador2() { return idJugador2; }
    public void setIdJugador2(Integer idJugador2) { this.idJugador2 = idJugador2; }
    public Integer getIdArbitro() { return idArbitro; }
    public void setIdArbitro(Integer idArbitro) { this.idArbitro = idArbitro; }
    public Integer getIdGanador() { return idGanador; }
    public void setIdGanador(Integer idGanador) { this.idGanador = idGanador; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public Integer getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(Integer duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public Ronda getRonda() { return ronda; }
    public void setRonda(Ronda ronda) { this.ronda = ronda; }
    public EstadoPartido getEstado() { return estado; }
    public void setEstado(EstadoPartido estado) { this.estado = estado; }
}