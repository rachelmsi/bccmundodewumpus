package br.cesupa.CC6TA.Mundo.Agente;

import br.cesupa.CC6TA.Mundo.Mapa.Mapa;
import br.cesupa.CC6TA.Mundo.Mapa.PosicaoDoMapa;
import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.TipoObjeto;

/**
 * @author Pedro
 */
public class Agente {

    private Mapa mapa;
    private PosicaoDoMapa agente;
    private HistoricoDoAgente historico;
    private int pontuacao;
    // variaveis boolean de estado do agente
    private boolean pegouOuro, voltou, morreu;

    public Agente(Mapa mapa) {
        this.mapa = mapa;
        agente = mapa.getMapa()[0][0];
        historico = new HistoricoDoAgente();
        pontuacao = 0; // TODO: implementar a pontuacao

        pegouOuro = voltou = morreu = false;

//        JOptionPane.showMessageDialog(null, agente.getPosicaoX());
//        JOptionPane.showMessageDialog(null, agente.getPosicaoY());
    }

    // Métodos do agente
    public void IniciarAventura() {
        iniciarPercepcao();
    }
//    private boolean visitadoPeloAgente;
//    private boolean casaSegura;
//    private boolean wumpus;
//    private boolean buraco;

    public void iniciarPercepcao() {
        if (isSeguro(agente.getPosicaoX(), agente.getPosicaoY())) {



            if (possuiBrisa(agente.getPosicaoX(), agente.getPosicaoY())) {
            }

            if (possuiFedor(agente.getPosicaoX(), agente.getPosicaoY())) {
            }
        } else {
            historico.appendHistorico("O agente foi morto");
        }
    }

    public boolean isSeguro(int posicaoX, int posicaoY) {
        if (possuiWumpus(posicaoX, posicaoY) || possuiBuraco(posicaoX, posicaoY)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean possuiWumpus(int posicaoX, int posicaoY) {
        if (mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno().getTipoObjeto() == TipoObjeto.WUMPUS) {
            return true;
        } else {
            return false;
        }
    }

    public boolean possuiBuraco(int posicaoX, int posicaoY) {
        if (mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno().getTipoObjeto() == TipoObjeto.BURACO) {
            return true;
        } else {
            return false;
        }
    }

    public boolean possuiOuro(int posicaoX, int posicaoY) {
        if (mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno().getTipoObjeto() == TipoObjeto.OURO) {
            return true;
        } else {
            return false;
        }
    }

    public boolean possuiBrisa(int posicaoX, int posicaoY) {
        return mapa.getMapa()[posicaoX][posicaoY].isBrisa();
    }

    public boolean possuiFedor(int posicaoX, int posicaoY) {
        return mapa.getMapa()[posicaoX][posicaoY].isFedor();
    }
}
