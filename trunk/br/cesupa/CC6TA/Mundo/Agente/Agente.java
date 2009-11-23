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
    private boolean cima = true;
    private boolean baixo = false;
    private boolean direita = true;
    private boolean esquerda = false;

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
    public void iniciarAventura() {
//        do {
            iniciarPercepcao();
            if (morreu == false) {
                moverAgente();
            }
//        } while (morreu == false);
    }
//    private boolean visitadoPeloAgente;
//    private boolean casaSegura;
//    private boolean wumpus;
//    private boolean buraco;

    public void iniciarPercepcao() {
        if (!agente.isVisitadoPeloAgente()) {
            if (aindaEstaVivo(agente.getPosicaoX(), agente.getPosicaoY())) {

                agente.setVisitadoPeloAgente(true);
                agente.setCasaSegura(true);

                if (nenhumaPercepcaoDeFedorOuBrisa(agente.getPosicaoX(), agente.getPosicaoY())) {
                    definirCasasSegurasAoRedor(agente.getPosicaoX(), agente.getPosicaoY());
                    historico.appendHistorico("O agente não detectou nada na posicao: " + agente.getPosicaoX() + " x " + agente.getPosicaoY());

                } else {
                    if (possuiBrisa(agente.getPosicaoX(), agente.getPosicaoY())) {
                        definirPerigoDeBuracoAoRedor(agente.getPosicaoX(), agente.getPosicaoY());
                        historico.appendHistorico("O agente detectou brisa na posicao: " + agente.getPosicaoX() + " x " + agente.getPosicaoY());
                    }

                    if (possuiFedor(agente.getPosicaoX(), agente.getPosicaoY())) {
                        definirPerigoDeWumpusAoRedor(agente.getPosicaoX(), agente.getPosicaoY());
                        historico.appendHistorico("O agente detectou fedor na posicao: " + agente.getPosicaoX() + " x " + agente.getPosicaoY());
                    }
                }
            } else {
                morreu = true;
                pontuacao -= 1000;
                historico.appendHistorico("O agente foi morto, -1000 de pontuação");
            }
        }
    }

    public void moverAgente() {
    }

    public int possiveisMovimentos() {
        int movimentos = 0;

        if (cima) {
            movimentos++;
        }
        if (baixo) {
            movimentos++;
        }
        if (direita) {
            movimentos++;
        }
        if (esquerda) {
            movimentos++;
        }
        return movimentos;
    }

    public String sorteiaPosicaoParaAndar(int possiveisMovimentos) {
        int random = (int) (Math.random() * possiveisMovimentos);

        if (random == 0) {
//            return encontrarTrue(0);
        }
        if (random == 1) {
//            return encontrarTrue(1);
        }
        if (random == 2) {
//            return encontrarTrue(2);
        }
        if (random == 3) {
//            return encontrarTrue(3);
        }
        return "";
    }

    public boolean aindaEstaVivo(int posicaoX, int posicaoY) {
        if (possuiWumpus(posicaoX, posicaoY) || possuiBuraco(posicaoX, posicaoY)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean possuiWumpus(int posicaoX, int posicaoY) {
        if (mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno() == null) {
            return false;
        }
        if (mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno().getTipoObjeto() == TipoObjeto.WUMPUS) {
            return true;
        } else {
            return false;
        }
    }

    public boolean possuiBuraco(int posicaoX, int posicaoY) {

        if (mapa.getMapa()[posicaoX][posicaoY].getObjetoDoTerreno() == null) {
            return false;
        }
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

    public boolean nenhumaPercepcaoDeFedorOuBrisa(int posicaoX, int posicaoY) {
        if (possuiBrisa(posicaoX, posicaoY) || possuiFedor(posicaoX, posicaoY)) {
            return false;
        } else {
            return true;
        }
    }

    public void definirPerigoDeBuracoAoRedor(int posicaoX, int posicaoY) {

        int linhas = mapa.getLinhas() - 1;
        int colunas = mapa.getColunas() - 1;

        if (!(posicaoX + 1 > linhas)) {
            mapa.getMapa()[posicaoX + 1][posicaoY].setBuraco(true);
        }

        if (!(posicaoX - 1 < 0)) {
            mapa.getMapa()[posicaoX - 1][posicaoY].setBuraco(true);
        }


        if (!(posicaoY + 1 > colunas)) {
            mapa.getMapa()[posicaoX][posicaoY + 1].setBuraco(true);
        }

        if (!(posicaoY - 1 < 0)) {
            mapa.getMapa()[posicaoX][posicaoY - 1].setBuraco(true);
        }
    }

    public void definirPerigoDeWumpusAoRedor(int posicaoX, int posicaoY) {
        int linhas = mapa.getLinhas() - 1;
        int colunas = mapa.getColunas() - 1;

        if (!(posicaoX + 1 > linhas)) {
            mapa.getMapa()[posicaoX + 1][posicaoY].setWumpus(true);
        }

        if (!(posicaoX - 1 < 0)) {
            mapa.getMapa()[posicaoX - 1][posicaoY].setWumpus(true);
        }


        if (!(posicaoY + 1 > colunas)) {
            mapa.getMapa()[posicaoX][posicaoY + 1].setWumpus(true);
        }

        if (!(posicaoY - 1 < 0)) {
            mapa.getMapa()[posicaoX][posicaoY - 1].setWumpus(true);
        }
    }

    public void definirCasasSegurasAoRedor(int posicaoX, int posicaoY) {
        int linhas = mapa.getLinhas() - 1;
        int colunas = mapa.getColunas() - 1;

        if (!(posicaoX + 1 > linhas)) {
            mapa.getMapa()[posicaoX + 1][posicaoY].setCasaSegura(true);
        }

        if (!(posicaoX - 1 < 0)) {
            mapa.getMapa()[posicaoX - 1][posicaoY].setCasaSegura(true);
        }


        if (!(posicaoY + 1 > colunas)) {
            mapa.getMapa()[posicaoX][posicaoY + 1].setCasaSegura(true);
        }

        if (!(posicaoY - 1 < 0)) {
            mapa.getMapa()[posicaoX][posicaoY - 1].setCasaSegura(true);
        }
    }

    public HistoricoDoAgente getHistorico() {
        return this.historico;
    }
}


