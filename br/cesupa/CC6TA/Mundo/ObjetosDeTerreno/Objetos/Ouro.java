package br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.*;

/**
 *
 * @author pedro
 */
public class Ouro extends ObjetoDoTerreno {

    public Ouro() {
        this.setTipoObjeto(TipoObjeto.OURO);
    }

    @Override
    public void emitirEvento() {
        //TODO: Implementar as regras do emitirEvento
        System.out.println("Sou o Ouro");
    }
}
