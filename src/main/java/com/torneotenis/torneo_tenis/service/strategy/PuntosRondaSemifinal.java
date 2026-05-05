package com.torneotenis.torneo_tenis.service.strategy;

public class PuntosRondaSemifinal implements EstrategiaPuntos {
    @Override
    public int calcularPuntos() {
        return 60;
    }
}