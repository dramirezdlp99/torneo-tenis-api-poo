package com.torneotenis.torneo_tenis.model;

import com.torneotenis.torneo_tenis.model.enums.Categoria;
import com.torneotenis.torneo_tenis.model.enums.Superficie;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "torneos")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String ciudad;
    private String pais;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer premioTotal;

    @Enumerated(EnumType.STRING)
    private Superficie superficie;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Torneo() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
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