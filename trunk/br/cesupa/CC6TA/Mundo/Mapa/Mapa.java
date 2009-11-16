package bccmundodewumpus.br.cesupa.CC6TA.Mundo.Mapa;

/**
 *
 * @author Pedro
 */
public class Mapa {
    private PosicaoDoMapa[][] mapa;

    public Mapa() {
        mapa = new PosicaoDoMapa[4][4];
    }

    public Mapa(int linhas, int colunas) {
        mapa = new PosicaoDoMapa[linhas][colunas];
    }
}
