package br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.*;

/**
 *
 * @author pedro
 */
public class Ouro extends ObjetoDoTerreno {

    public Ouro(int posicaoX, int posicaoY) {
        this.setPosicaoX(posicaoX);
        this.setPosicaoY(posicaoY);
        this.setTipoObjeto(TipoObjeto.OURO);
    }

    @Override
    public void emitirEvento() {
        this.getMapa().getMapa()[this.getPosicaoX()][this.getPosicaoY()].setResplendor(true);
        System.out.println("Sou o ouro e realizei meu evento");
    }
}
