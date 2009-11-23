package br.cesupa.CC6TA.Mundo.Jogo;

import br.cesupa.CC6TA.Mundo.Jogo.ExceptionsDoJogo.ObjetoJaCriadoException;
import br.cesupa.CC6TA.Mundo.Jogo.ExceptionsDoJogo.PosicaoReservadaParaAgenteException;
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
    private int contadorWumpus, contadorBuraco, contadorOuro; // TODO: implementar funcionalidade de controlar número de objetos criados

    /**
     * Instancia um novo mapa, o construtor do mapa sem parâmetros
     * cria por padrão um array posicaoDoMapa[4][4]
     */
    public Partida() {
        mapa = new Mapa();
        contadorWumpus = contadorBuraco = contadorOuro = 0;
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
    public void criaWumpus(int posicaoX, int posicaoY) throws PosicaoReservadaParaAgenteException, ObjetoJaCriadoException {
        setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Wumpus(posicaoX, posicaoY));
        contadorWumpus++;
    }

    /**
     * Cria um novo objeto do tipo Ouro
     * @param posicaoX posicao x do ouro
     * @param posicaoY posicao y do ouro
     */
    public void criaOuro(int posicaoX, int posicaoY) throws PosicaoReservadaParaAgenteException, ObjetoJaCriadoException {
        setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Ouro(posicaoX, posicaoY));
        contadorOuro++;
    }

    /**
     * Cria um novo objeto do tipo burado
     * @param posicaoX posicao x do buraco
     * @param posicaoY posicao y do buraco
     */
    public void criaBuraco(int posicaoX, int posicaoY) throws PosicaoReservadaParaAgenteException, ObjetoJaCriadoException {
        setObjetoDaPosicaoDoMapa(posicaoX, posicaoY, new Buraco(posicaoX, posicaoY));
        contadorBuraco++;
    }

    /**
     * Cria um determinado objeto de terreno em uma posição [posicaoX][posicaoY] e manda o mapa instanciado para definir os atributos como
     * brisa, fedor e explendor
     * @param posicaoX posicao x de onde vai ser criado o objeto
     * @param posicaoY posicao y de onde vai ser criado o objeto
     * @param objetoDoTerreno define o tipo do objeto (new Wumpus(), new Ouro() ou new Buraco())
     */
    public void setObjetoDaPosicaoDoMapa(int posicaoX, int posicaoY, ObjetoDoTerreno objetoDoTerreno) throws PosicaoReservadaParaAgenteException, ObjetoJaCriadoException {

        if (posicaoX == 0 && posicaoY == 0) {
            throw new PosicaoReservadaParaAgenteException();
        } else if (this.getObjetoDaPosicaoDoMapa(posicaoX, posicaoY) == null) {
            this.mapa.getMapa()[posicaoX][posicaoY].setObjetoDoTerreno(objetoDoTerreno);
            this.mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno().setMapa(this.mapa);
            this.mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno().emitirEvento();
        } else {
            throw new ObjetoJaCriadoException();
        }
    }

    public ObjetoDoTerreno getObjetoDaPosicaoDoMapa(int posicaoX, int posicaoY) {
        return this.mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno();
    }

    /**
     * @return mapa instanciado em uma determinada partida
     */
    public Mapa getMapa() {
        return mapa;
    }
}
