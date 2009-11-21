package br.cesupa.CC6TA.Mundo.Jogo;

import br.cesupa.CC6TA.Mundo.Mapa.Mapa;
import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos.Buraco;
import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.ObjetoDoTerreno;
import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos.Ouro;
import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.Objetos.Wumpus;

/**
 *
 * @author Pedro
 */
public class Partida {

    private Mapa mapa;

    /**
     * Instancia um novo mapa, o construtor do mapa sem parâmetros
     * cria por padrão um array posicaoDoMapa[4][4]
     */
    public Partida() {
        mapa = new Mapa();
    }

    /**
     * Instancia um novo mapa
     * @param linhas número de linhas do mapa
     * @param colunas número de colunas do mapa
     */
    public Partida(int linhas, int colunas) {
        mapa = new Mapa(linhas, colunas);
    }

    /**
     * Cria um novo objeto do tipo Wumpus
     * @param posicaoX posicao x do wumpus
     * @param posicaoY posicao y do wumpus
     */

    public void criaWumpus(int posicaoX, int posicaoY) {
        setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Wumpus());
    }

    /**
     * Cria um novo objeto do tipo Ouro
     * @param posicaoX posicao x do ouro
     * @param posicaoY posicao y do ouro
     */
    public void criaOuro(int posicaoX, int posicaoY) {
        setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Ouro());
    }

    /**
     * Cria um novo objeto do tipo burado
     * @param posicaoX posicao x do buraco
     * @param posicaoY posicao y do buraco
     */
    public void criaBuraco(int posicaoX, int posicaoY) {
        setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Buraco());
    }

    /**
     * Cria um determinado objeto de terreno em uma posição [posicaoX][posicaoY] e manda o mapa instanciado para definir os atributos como
     * brisa, fedor e explendor
     * @param posicaoX posicao x de onde vai ser criado o objeto
     * @param posicaoY posicao y de onde vai ser criado o objeto
     * @param objetoDoTerreno define o tipo do objeto (new Wumpus(), new Ouro() ou new Buraco())
     */
    public void setObjetoDaPosicaoDoMapa(int posicaoX, int posicaoY, ObjetoDoTerreno objetoDoTerreno) {
        this.mapa.getMapa()[posicaoX][posicaoY].setObjetoDoTerreno(objetoDoTerreno, this.mapa.getMapa());
        //mapa[posicaoX][posicaoY].getObjetoDoTerreno().emitirEvento();
    }

    /**
     * @return mapa instanciado em uma determinada partida
     */
    public Mapa getMapa() {
        return mapa;
    }
}
