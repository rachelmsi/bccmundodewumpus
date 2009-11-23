package br.cesupa.CC6TA.Mundo.Mapa;

/**
 *
 * @author Pedro
 */
public class Mapa {
    private PosicaoDoMapa[][] mapa;
    private int linhas;
    private int colunas;

    // construtores
    /**
     * Cria o mapa por padrão com 4 linhas e 4 colunas
     */
    public Mapa() {
        this.linhas = 4;
        this.colunas = 4;
        mapa = new PosicaoDoMapa[linhas][colunas];

        for(int posicaoX = 0; posicaoX < linhas; posicaoX++) {
            for(int posicaoY = 0; posicaoY < colunas; posicaoY++) {
                mapa[posicaoX][posicaoY] = new PosicaoDoMapa(posicaoX, posicaoY);
            }
        }
    }

    /**
     * Cria o mapa com linhas e colunas iguais aos parâmetros fornecidos
     * @param linhas número de linhas do mapa a ser criado
     * @param colunas números de colunas do mapa a ser criado
     */
    public Mapa(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        mapa = new PosicaoDoMapa[linhas][colunas];

        for(int posicaoX = 0; posicaoX < linhas; posicaoX++) {
            for(int posicaoY = 0; posicaoY < colunas; posicaoY++) {
                mapa[posicaoX][posicaoY] = new PosicaoDoMapa(posicaoX, posicaoY);
            }
        }
    }

    // sets e gets
    public PosicaoDoMapa[][] getMapa() {
        return mapa;
    }

    public void setMapa(PosicaoDoMapa[][] mapa) {
        this.mapa = mapa;
    }

    public int getLinhas() {
        return this.linhas;
    }

    public int getColunas() {
        return this.colunas;
    }
}
