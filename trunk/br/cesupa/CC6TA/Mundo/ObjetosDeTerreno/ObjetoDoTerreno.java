package br.cesupa.CC6TA.Mundo.ObjetosDeTerreno;

import br.cesupa.CC6TA.Mundo.Mapa.Mapa;

/**
 *
 * @author Pedro
 */
public class ObjetoDoTerreno implements ObjetoDoTerrenoInterface {

    private int posicaoX, posicaoY;
    private Mapa mapa;
    private TipoObjeto tipoObjeto;

    // Contrutores
    public ObjetoDoTerreno() {
        super();
    }

    public ObjetoDoTerreno(int posicaoX, int posicaoY) {
        super();
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }
    // Fim Construtores

    public void emitirEvento() {
        //TODO: Implementar as regras do emitirEvento
    }

    // Sets e Gets
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

    public TipoObjeto getTipoObjeto() {
        return this.tipoObjeto;
    }

    public void setTipoObjeto(TipoObjeto tipo) {
        this.tipoObjeto = tipo;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
}
