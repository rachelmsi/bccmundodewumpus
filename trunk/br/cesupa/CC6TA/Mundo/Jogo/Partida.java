package bccmundodewumpus.br.cesupa.CC6TA.Mundo.Jogo;

import bccmundodewumpus.br.cesupa.CC6TA.Mundo.Mapa.Mapa;
import bccmundodewumpus.br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Buraco;
import bccmundodewumpus.br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Ouro;
import bccmundodewumpus.br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Wumpus;

/**
 *
 * @author Pedro
 */
public class Partida {

    private Mapa mapa;

    public Partida() {
        mapa = new Mapa();
    }

    public Partida(int linhas, int colunas) {
        mapa = new Mapa(linhas, colunas);
    }

    public void criaWumpus(int posicaoX, int posicaoY) {
        mapa.setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Wumpus());
    }

    public void criaOuro(int posicaoX, int posicaoY) {
        mapa.setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Ouro());
    }

    public void criaBuraco(int posicaoX, int posicaoY) {
        mapa.setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Buraco());
    }

}
