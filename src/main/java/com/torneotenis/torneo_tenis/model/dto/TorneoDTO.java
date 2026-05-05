package com.torneotenis.torneo_tenis.model.dto;

import com.torneotenis.torneo_tenis.model.enums.Categoria;
import com.torneotenis.torneo_tenis.model.enums.Superficie;
import java.time.LocalDate;

public class TorneoDTO {

    private String nombre;
    private String ciudad;
    private String pais;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer premioTotal;
    private Superficie superficie;
    private Categoria categoria;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public Integer getPremioTotal() { return premioTotal; }
    public void setPremioTotal(Integer premioTotal) { this.premioTotal = premioTotal; }
    public Superficie getSuperficie() { return superficie; }
    public void setSuperficie(Superficie superficie) { this.superficie = superficie; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}