package bccmundodewumpus.br.cesupa.CC6TA.Mundo.Mapa;

import bccmundodewumpus.br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.ObjetoDoTerreno;

/**
 *
 * @author Pedro
 */
public class Mapa {
    private PosicaoDoMapa[][] mapa;

    // construtores
    /**
     * Cria o mapa por padrão com 4 linhas e 4 colunas
     */
    public Mapa() {
        mapa = new PosicaoDoMapa[4][4];

        for(int posicaoX = 0; posicaoX < 4; posicaoX++) {
            for(int posicaoY = 0; posicaoY < 4; posicaoY++) {
                mapa[posicaoX][posicaoY] = new PosicaoDoMapa(posicaoX, posicaoY);
            }
        }
    }

    /**
     * Cria o mapa com linhas e colunas iguais aos parâmetros fornecidos
     * @param linhas número de linhas do mapa
     * @param colunas números de colunas do mapa
     */
    public Mapa(int linhas, int colunas) {
        mapa = new PosicaoDoMapa[linhas][colunas];

        for(int posicaoX = 0; posicaoX < linhas; posicaoX++) {
            for(int posicaoY = 0; posicaoY < colunas; posicaoY++) {
                mapa[posicaoX][posicaoY] = new PosicaoDoMapa(posicaoX, posicaoY);
            }
        }
    }

    /**
     * Cria um determinado objeto de terreno em uma posição [posicaoX][posicaoY]
     * @param posicaoX posicao x de onde vai ser criado o objeto
     * @param posicaoY posicao y de onde vai ser criado o objeto
     * @param objetoDoTerreno define o tipo do objeto (new Wumpus(), new Ouro() ou new Buraco())
     */
    public void setObjetoDaPosicaoDoMapa(int posicaoX, int posicaoY, ObjetoDoTerreno objetoDoTerreno) {
        mapa[posicaoX][posicaoY].setObjetoDoTerreno(objetoDoTerreno);
        mapa[posicaoX][posicaoY].getObjetoDoTerreno().emitirEvento();
    }

    // sets e gets
    public PosicaoDoMapa[][] getMapa() {
        return mapa;
    }

    public void setMapa(PosicaoDoMapa[][] mapa) {
        this.mapa = mapa;
    }
}
