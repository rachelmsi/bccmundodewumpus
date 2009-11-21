package br.cesupa.CC6TA.Mundo.Mapa;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.ObjetoDoTerreno;

/**
 * @author Pedro
 */
public class PosicaoDoMapa<T> {
    private int posicaoX, posicaoY;
    private ObjetoDoTerreno objetoDoTerreno;
    private boolean esplendor, fedor, brisa;

    //construtor
    public PosicaoDoMapa(int posicaoX, int posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.esplendor = this.fedor = this.brisa = false;
        this.objetoDoTerreno = null;
    }

    // sets e gets
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

    public boolean isEsplendor() {
        return esplendor;
    }

    public void setEsplendor(boolean esplendor) {
        this.esplendor = esplendor;
    }

    public boolean isFedor() {
        return fedor;
    }

    public void setFedor(boolean fedor) {
        this.fedor = fedor;
    }

    public boolean isBrisa() {
        return brisa;
    }

    public void setBrisa(boolean brisa) {
        this.brisa = brisa;
    }
}
