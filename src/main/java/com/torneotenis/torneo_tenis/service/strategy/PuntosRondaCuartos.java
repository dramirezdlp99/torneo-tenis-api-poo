package com.torneotenis.torneo_tenis.service.strategy;

public class PuntosRondaCuartos implements EstrategiaPuntos {
    @Override
    public int calcularPuntos() {
        return 40;
    }
}