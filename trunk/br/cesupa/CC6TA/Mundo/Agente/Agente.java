package br.cesupa.CC6TA.Mundo.Agente;

import br.cesupa.CC6TA.Mundo.Mapa.Mapa;
import br.cesupa.CC6TA.Mundo.Mapa.PosicaoDoMapa;

/**
 * Luti....
 * @author 
 */
public class Agente {
    PosicaoDoMapa agente;
    Mapa mapa;

    public Agente(Mapa mapa) {
        this.mapa = mapa;
        agente = mapa.getMapa()[0][0];
    }
}