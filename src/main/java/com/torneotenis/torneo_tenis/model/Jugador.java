package com.torneotenis.torneo_tenis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador extends Persona {

    private Integer ranking;
    private Integer puntosAcumulados;
    private Integer titulos;

    public Jugador() {}

    public Integer getRanking() { return ranking; }
    public void setRanking(Integer ranking) { this.ranking = ranking; }
    public Integer getPuntosAcumulados() { return puntosAcumulados; }
    public void setPuntosAcumulados(Integer puntosAcumulados) { this.puntosAcumulados = puntosAcumulados; }
    public Integer getTitulos() { return titulos; }
    public void setTitulos(Integer titulos) { this.titulos = titulos; }
}