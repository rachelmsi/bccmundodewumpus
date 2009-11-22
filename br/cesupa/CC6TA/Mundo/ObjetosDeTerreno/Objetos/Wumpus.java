package br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.*;

/**
 *
 * @author pedro
 */
public class Wumpus extends ObjetoDoTerreno {

    public Wumpus() {
        this.setTipoObjeto(TipoObjeto.WUMPUS);
    }

    @Override
    public void emitirEvento() {
        //TODO: Implementar as regras do emitirEvento
        System.out.println("Sou um Wumpus");
    }
}
