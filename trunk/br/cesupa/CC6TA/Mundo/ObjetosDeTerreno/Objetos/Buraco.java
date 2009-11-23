package br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.*;

/**
 * 
 * @author pedro
 */
public class Buraco extends ObjetoDoTerreno {

    public Buraco(int posicaoX, int posicaoY) {
        this.setPosicaoX(posicaoX);
        this.setPosicaoY(posicaoY);
        this.setTipoObjeto(TipoObjeto.BURACO);
    }

    @Override
    public void emitirEvento() {
        int linhas = this.getMapa().getLinhas() - 1; 
        int colunas = this.getMapa().getColunas() - 1;

        if (!(this.getPosicaoX() + 1 > linhas)) {
            this.getMapa().getMapa()[this.getPosicaoX() + 1][this.getPosicaoY()].setBrisa(true);
        }
        
        if (!(this.getPosicaoX() - 1 < 0)) {
            this.getMapa().getMapa()[this.getPosicaoX() - 1][this.getPosicaoY()].setBrisa(true);
        }
        
        
        if (!(this.getPosicaoY() + 1 > colunas)) {
            this.getMapa().getMapa()[this.getPosicaoX()][this.getPosicaoY() + 1].setBrisa(true);
        }
        
        if (!(this.getPosicaoY() - 1 < 0)) {
            this.getMapa().getMapa()[this.getPosicaoX()][this.getPosicaoY() - 1].setBrisa(true);
        }
        
        System.out.println("Sou um buraco e realizei meu evento");
        
    }
}
