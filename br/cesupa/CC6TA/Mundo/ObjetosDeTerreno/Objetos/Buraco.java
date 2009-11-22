package br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.*;

/**
 * @author pedro
 */
public class Buraco extends ObjetoDoTerreno {

    public Buraco() {
        this.setTipoObjeto(TipoObjeto.BURACO);
    }

    @Override
    public void emitirEvento() {
        //TODO: Implementar as regras do emitirEvento
        Buraco b = new Buraco();

        System.out.println("Sou um buraco");
    }
}
