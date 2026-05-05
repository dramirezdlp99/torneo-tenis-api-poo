package com.torneotenis.torneo_tenis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "arbitros")
public class Arbitro extends Persona {

    private String licencia;
    private Integer aniosExperiencia;

    public Arbitro() {}

    public String getLicencia() { return licencia; }
    public void setLicencia(String licencia) { this.licencia = licencia; }
    public Integer getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(Integer aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }
}