package com.torneotenis.torneo_tenis.model.dto;

public class JugadorDTO {

    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String correo;
    private Integer ranking;
    private Integer puntosAcumulados;
    private Integer titulos;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public Integer getRanking() { return ranking; }
    public void setRanking(Integer ranking) { this.ranking = ranking; }
    public Integer getPuntosAcumulados() { return puntosAcumulados; }
    public void setPuntosAcumulados(Integer puntosAcumulados) { this.puntosAcumulados = puntosAcumulados; }
    public Integer getTitulos() { return titulos; }
    public void setTitulos(Integer titulos) { this.titulos = titulos; }
}