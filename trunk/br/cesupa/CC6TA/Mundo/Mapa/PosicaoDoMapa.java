package bccmundodewumpus.br.cesupa.CC6TA.Mundo.Mapa;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.ObjetoDoTerreno;

/**
 * @author Pedro
 */
public class PosicaoDoMapa<T> {
    private int posicaoX, posicaoY;
    private ObjetoDoTerreno objetoDoTerreno;

    public PosicaoDoMapa(int posicaoX, int posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public ObjetoDoTerreno getObjetoDoTerreno() {
        return objetoDoTerreno;
    }

    public void setObjetoDoTerreno(T t) {
        this.objetoDoTerreno = (ObjetoDoTerreno) t;
    }
}
