package br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.*;

/**
 *
 * @author pedro
 */
public class Wumpus extends ObjetoDoTerreno {

    public Wumpus(int posicaoX, int posicaoY) {
        this.setPosicaoX(posicaoX);
        this.setPosicaoY(posicaoY);
        this.setTipoObjeto(TipoObjeto.WUMPUS);
    }

    @Override
    public void emitirEvento() {
        int linhas = this.getMapa().getLinhas() - 1; 
        int colunas = this.getMapa().getColunas() - 1;

        if (!(this.getPosicaoX() + 1 > linhas)) {
            this.getMapa().getMapa()[this.getPosicaoX() + 1][this.getPosicaoY()].setFedor(true);
        }
        
        if (!(this.getPosicaoX() - 1 < 0)) {
            this.getMapa().getMapa()[this.getPosicaoX() - 1][this.getPosicaoY()].setFedor(true);
        }
        
        
        if (!(this.getPosicaoY() + 1 > colunas)) {
            this.getMapa().getMapa()[this.getPosicaoX()][this.getPosicaoY() + 1].setFedor(true);
        }
        
        if (!(this.getPosicaoY() - 1 < 0)) {
            this.getMapa().getMapa()[this.getPosicaoX()][this.getPosicaoY() - 1].setFedor(true);
        }
        System.out.println("Sou o wumpus e realizei meu evento");

    }
}
