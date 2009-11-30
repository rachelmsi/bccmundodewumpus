package br.cesupa.CC6TA.Mundo.Agente;

import br.cesupa.CC6TA.Mundo.Mapa.Mapa;
import br.cesupa.CC6TA.Mundo.Mapa.PosicaoDoMapa;
import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.TipoObjeto;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pedro
 */
public class Agente {

    private Mapa mapa;
    private PosicaoDoMapa agente;
    private Historico historico;
    private int pontuacao;
    private Personalidade personalidade;
    // variaveis boolean de estado do agente
    private boolean pegouOuro, voltou, morreu;

    public Agente(Mapa mapa) {
        this.mapa = mapa;
        agente = mapa.getMapa()[0][0];
        historico = new Historico();
        pontuacao = 0; // TODO: implementar a pontuacao
        pegouOuro = voltou = morreu = false;
        personalidade = Personalidade.CUIDADOSO;
    }

    // Métodos do agente
    public void iniciarAventura() {
        do {
            iniciarPercepcao();
            if (morreu == false) {
                moverAgente();
            }
        } while (morreu == false && pegouOuro == false);
    }
//    private boolean visitadoPeloAgente;
//    private boolean casaSegura;
//    private boolean wumpus;
//    private boolean buraco;

    public void iniciarPercepcao() {
        if (!agente.isVisitadoPeloAgente()) {
            if (aindaEstaVivo()) {

                if (possuiOuro()) {
                    pegouOuro = true;
                    historico.appendHistorico("Ouro encontrado na posição: " + agente.getPosicaoX() + " x " + agente.getPosicaoY() + ", +1000 Pontos");
                    pontuacao += 1000;
                    pegouOuro = true;
                } else {

                    agente.setVisitadoPeloAgente(true);
                    agente.setCasaSegura(true);

                    if (nenhumaPercepcaoDeFedorOuBrisa()) {
                        historico.appendHistorico("O agente não detectou nada na posicao: " + agente.getPosicaoX() + " x " + agente.getPosicaoY());
                        definirCasasSegurasAoRedor();

                    } else {
                        if (possuiBrisa()) {
                            historico.appendHistorico("O agente detectou brisa na posicao: " + agente.getPosicaoX() + " x " + agente.getPosicaoY());
                            definirPerigoDeBuracoAoRedor();

                        }

                        if (possuiFedor()) {
                            historico.appendHistorico("O agente detectou fedor na posicao: " + agente.getPosicaoX() + " x " + agente.getPosicaoY());
                            definirPerigoDeWumpusAoRedor();
                        }
                    }
                    corrigirErroDeCasasSegurasQuePossuemAtributosDePerigo();
                }
            } else {
                morreu = true;
            }
        }
    }

    public void moverAgente() {
        if (istodasOK()) {
            PosicaoDoMapa casaNaoVisitada = sorteiaPosicaoParaAndar(getCasasNaoVisitadas());
            if (casaNaoVisitada != null) {
                agente = casaNaoVisitada;
                historico.appendHistorico("Todas as casas OK. Agente move-se para casa ainda nao visitada: " + casaNaoVisitada.getPosicaoX() + " x " + casaNaoVisitada.getPosicaoY() + ", -1 Ponto");
                pontuacao += -1;
            } else {
                PosicaoDoMapa casaVisitada = sorteiaPosicaoParaAndar(getCasasVisitadas());
                agente = casaVisitada;
                historico.appendHistorico("Todas as casas OK. Agente agora é um explorador. Agente move-se para casa: " + casaVisitada.getPosicaoX() + " x " + casaVisitada.getPosicaoY() + ", -1 Ponto");
                pontuacao += -1;
                personalidade = Personalidade.EXPLORADOR;
            }
        } else if (istodasPerigosas()) {
            PosicaoDoMapa casaDisponivel = sorteiaPosicaoParaAndar(getCasasDisponiveis());
            agente = casaDisponivel;
            historico.appendHistorico("Todas as casas são perigosas. Agente arrisca e move-se para casa: " + casaDisponivel.getPosicaoX() + " x " + casaDisponivel.getPosicaoY() + ", -1 Ponto");
            pontuacao += -1;
        } else {
            PosicaoDoMapa casaPerigosa = sorteiaPosicaoParaAndar(getCasasPerigosas());
            PosicaoDoMapa casaSegura = sorteiaPosicaoParaAndar(getCasasSeguras());
            PosicaoDoMapa casaVisitada = sorteiaPosicaoParaAndar(getCasasVisitadas());
            PosicaoDoMapa casaNaoVisitada = sorteiaPosicaoParaAndar(getCasasNaoVisitadas());

            if (personalidade == Personalidade.CUIDADOSO) {
                if (casaNaoVisitada != null) {
                    if (casaNaoVisitada == casaSegura) {
                        agente = casaNaoVisitada;
                        historico.appendHistorico("Agente move-se para casa ainda não visitada: " + casaNaoVisitada.getPosicaoX() + " x " + casaNaoVisitada.getPosicaoY() + ", -1 Ponto");
                        pontuacao += -1;
                    } else {
                        agente = casaSegura;
                        historico.appendHistorico("Agente move-se para casa: " + casaSegura.getPosicaoX() + " x " + casaSegura.getPosicaoY() + ", -1 Ponto");
                        pontuacao += -1;
                    }
                }
            } else {
                if (casaNaoVisitada != null) {
                    personalidade = Personalidade.CUIDADOSO;
                    if (casaNaoVisitada == casaSegura) {
                        agente = casaNaoVisitada;
                        historico.appendHistorico("Agente ficou cuidadoso e move-se para casa ainda não visitada: " + casaNaoVisitada.getPosicaoX() + " x " + casaNaoVisitada.getPosicaoY() + ", -1 Ponto");
                        pontuacao += -1;
                    } else {
                        agente = casaPerigosa;
                        historico.appendHistorico("Agente arrisca, fica cuidadoso e move-se para casa: " + casaPerigosa.getPosicaoX() + " x " + casaPerigosa.getPosicaoY() + ", -1 Ponto");
                        pontuacao += -1;
                        personalidade = Personalidade.CUIDADOSO;
                    }
                }
            }
        }
    }

    public boolean istodasVisitadas() {
        List<PosicaoDoMapa> casasDisponiveis = getCasasDisponiveis();
        int contador = 0;

        for (int i = 0; i < casasDisponiveis.size(); i++) {
            if (casasDisponiveis.get(i).isVisitadoPeloAgente()) {
                contador++;
            }
        }

        if (contador == casasDisponiveis.size()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean istodasOK() {
        List<PosicaoDoMapa> casasDisponiveis = getCasasDisponiveis();
        int contador = 0;

        for (int i = 0; i < casasDisponiveis.size(); i++) {
            if (casasDisponiveis.get(i).isCasaSegura()) {
                contador++;
            }
        }

        if (contador == casasDisponiveis.size()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean istodasPerigosas() {
        List<PosicaoDoMapa> casasDisponiveis = getCasasDisponiveis();
        int contador = 0;

        for (int i = 0; i < casasDisponiveis.size(); i++) {
            if (casasDisponiveis.get(i).isPossibilidadeDeBuraco() || casasDisponiveis.get(i).isPossibilidadeDeWumpus()) {
                contador++;
            }
        }

        if (contador == casasDisponiveis.size()) {
            return true;
        } else {
            return false;
        }

    }

    public List<PosicaoDoMapa> getCasasPerigosas() {
        List<PosicaoDoMapa> casasDisponiveis = getCasasDisponiveis();
        List<PosicaoDoMapa> casasPerigosas = new ArrayList();

        for (int i = 0; i < casasDisponiveis.size(); i++) {
            if (casasDisponiveis.get(i).isPossibilidadeDeBuraco() || casasDisponiveis.get(i).isPossibilidadeDeWumpus()) {
                casasPerigosas.add(casasDisponiveis.get(i));
            }
        }

        return casasPerigosas;
    }

    public List<PosicaoDoMapa> getCasasSeguras() {
        List<PosicaoDoMapa> casasDisponiveis = getCasasDisponiveis();
        List<PosicaoDoMapa> casasSeguras = new ArrayList();

        for (int i = 0; i < casasDisponiveis.size(); i++) {
            if (casasDisponiveis.get(i).isCasaSegura()) {
                casasSeguras.add(casasDisponiveis.get(i));
            }
        }
        return casasSeguras;
    }

    public List<PosicaoDoMapa> getCasasVisitadas() {
        List<PosicaoDoMapa> casasDisponiveis = getCasasDisponiveis();
        List<PosicaoDoMapa> casasVisitadas = new ArrayList();

        for (int i = 0; i < casasDisponiveis.size(); i++) {
            if (casasDisponiveis.get(i).isVisitadoPeloAgente()) {
                casasVisitadas.add(casasDisponiveis.get(i));
            }
        }
        return casasVisitadas;
    }

    public List<PosicaoDoMapa> getCasasNaoVisitadas() {
        List<PosicaoDoMapa> casasDisponiveis = getCasasDisponiveis();
        List<PosicaoDoMapa> casasNaoVisitadas = new ArrayList();

        for (int i = 0; i < casasDisponiveis.size(); i++) {
            if (!casasDisponiveis.get(i).isVisitadoPeloAgente()) {
                casasNaoVisitadas.add(casasDisponiveis.get(i));
            }
        }
        return casasNaoVisitadas;
    }

    public List<PosicaoDoMapa> getCasasDisponiveis() {
        List<PosicaoDoMapa> casasDisponiveis = new ArrayList();

        if (getCima() != null) {
            casasDisponiveis.add(getCima());
        }

        if (getBaixo() != null) {
            casasDisponiveis.add(getBaixo());
        }

        if (getDireita() != null) {
            casasDisponiveis.add(getDireita());
        }

        if (getEsquerda() != null) {
            casasDisponiveis.add(getEsquerda());
        }
        return casasDisponiveis;
    }

    public PosicaoDoMapa sorteiaPosicaoParaAndar(List<PosicaoDoMapa> casas) {
        if (casas.size() == 0) {
            return null;
        }
        int random = (int) (Math.random() * casas.size());

        return casas.get(random);
    }

    public PosicaoDoMapa getCima() {
        if (!(agente.getPosicaoX() + 1 > this.mapa.getLinhas() - 1)) {
            return mapa.getMapa()[agente.getPosicaoX() + 1][agente.getPosicaoY()];
        } else {
            return null;
        }
    }

    public PosicaoDoMapa getBaixo() {
        if (!(agente.getPosicaoX() - 1 < 0)) {
            return mapa.getMapa()[agente.getPosicaoX() - 1][agente.getPosicaoY()];
        } else {
            return null;
        }
    }

    public PosicaoDoMapa getDireita() {
        if (!(agente.getPosicaoY() + 1 > this.mapa.getColunas() - 1)) {
            return mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY() + 1];
        } else {
            return null;
        }
    }

    public PosicaoDoMapa getEsquerda() {
        if (!(agente.getPosicaoY() - 1 < 0)) {
            return mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY() - 1];
        } else {
            return null;
        }
    }

    /**
     * Metodo utilizado para corrigir o erro de que em casa atribuida como OK ou visitada ficasse com possibilidadeDeBuraco e
     * possibilidadeDeWumpus como true
     */
    public void corrigirErroDeCasasSegurasQuePossuemAtributosDePerigo() {
        int linhas = mapa.getLinhas();
        int colunas = mapa.getColunas();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (mapa.getMapa()[i][j].isCasaSegura() || mapa.getMapa()[i][j].isVisitadoPeloAgente()) {
                    mapa.getMapa()[i][j].setPossibilidadeDeBuraco(false);
                    mapa.getMapa()[i][j].setPossibilidadeDeWumpus(false);
                }
            }
        }
    }

    public boolean aindaEstaVivo() {
        //agente.getPosicaoX(), agente.getPosicaoY()
        if (possuiWumpus()) {
            historico.appendHistorico("O agente foi morto pelo wumpus, -1000 Pontos");
            pontuacao = pontuacao - 1000;
            morreu = true;
            return false;
        } else if (possuiBuraco()) {
            historico.appendHistorico("O agente caiu num buraco, -1000 Pontos");
            pontuacao = pontuacao - 1000;
            morreu = true;
            return false;
        } else {
            return true;
        }
    }

    public boolean possuiWumpus() {
        if (mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY()].getObjetoDoTerreno() == null) {
            return false;
        }
        if (mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY()].getObjetoDoTerreno().getTipoObjeto() == TipoObjeto.WUMPUS) {
            return true;
        } else {
            return false;
        }
    }

    public boolean possuiBuraco() {

        if (mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY()].getObjetoDoTerreno() == null) {
            return false;
        }
        if (mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY()].getObjetoDoTerreno().getTipoObjeto() == TipoObjeto.BURACO) {
            return true;
        } else {
            return false;
        }
    }

    public boolean possuiOuro() {
        if (mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY()].getObjetoDoTerreno() == null) {
            return false;
        }
        if (mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY()].getObjetoDoTerreno().getTipoObjeto() == TipoObjeto.OURO) {
            return true;
        } else {
            return false;
        }
    }

    public boolean possuiBrisa() {
        return mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY()].isBrisa();
    }

    public boolean possuiFedor() {
        return mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY()].isFedor();
    }

    public boolean nenhumaPercepcaoDeFedorOuBrisa() {
        if (possuiBrisa() || possuiFedor()) {
            return false;
        } else {
            return true;
        }
    }

    public void definirPerigoDeBuracoAoRedor() {

        int linhas = mapa.getLinhas() - 1;
        int colunas = mapa.getColunas() - 1;

        if (!(agente.getPosicaoX() + 1 > linhas)) {
            mapa.getMapa()[agente.getPosicaoX() + 1][agente.getPosicaoY()].setPossibilidadeDeBuraco(true);
        }

        if (!(agente.getPosicaoX() - 1 < 0)) {
            mapa.getMapa()[agente.getPosicaoX() - 1][agente.getPosicaoY()].setPossibilidadeDeBuraco(true);
        }


        if (!(agente.getPosicaoY() + 1 > colunas)) {
            mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY() + 1].setPossibilidadeDeBuraco(true);
        }

        if (!(agente.getPosicaoY() - 1 < 0)) {
            mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY() - 1].setPossibilidadeDeBuraco(true);
        }

        historico.appendHistorico("Posições ao redor definidas com perigo de buraco");
    }

    public void definirPerigoDeWumpusAoRedor() {
        int linhas = mapa.getLinhas() - 1;
        int colunas = mapa.getColunas() - 1;

        if (!(agente.getPosicaoX() + 1 > linhas)) {
            mapa.getMapa()[agente.getPosicaoX() + 1][agente.getPosicaoY()].setPossibilidadeDeWumpus(true);
        }

        if (!(agente.getPosicaoX() - 1 < 0)) {
            mapa.getMapa()[agente.getPosicaoX() - 1][agente.getPosicaoY()].setPossibilidadeDeWumpus(true);
        }


        if (!(agente.getPosicaoY() + 1 > colunas)) {
            mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY() + 1].setPossibilidadeDeWumpus(true);
        }

        if (!(agente.getPosicaoY() - 1 < 0)) {
            mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY() - 1].setPossibilidadeDeWumpus(true);
        }
        historico.appendHistorico("Posições ao redor definidas com perigo de wumpus");
    }

    public void definirCasasSegurasAoRedor() {
        int linhas = mapa.getLinhas() - 1;
        int colunas = mapa.getColunas() - 1;

        if (!(agente.getPosicaoX() + 1 > linhas)) {
            mapa.getMapa()[agente.getPosicaoX() + 1][agente.getPosicaoY()].setCasaSegura(true);
        }

        if (!(agente.getPosicaoX() - 1 < 0)) {
            mapa.getMapa()[agente.getPosicaoX() - 1][agente.getPosicaoY()].setCasaSegura(true);
        }


        if (!(agente.getPosicaoY() + 1 > colunas)) {
            mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY() + 1].setCasaSegura(true);
        }

        if (!(agente.getPosicaoY() - 1 < 0)) {
            mapa.getMapa()[agente.getPosicaoX()][agente.getPosicaoY() - 1].setCasaSegura(true);
        }
        historico.appendHistorico("Posições ao redor definidas como seguras");
    }

    // sets e gets
    public Historico getHistorico() {
        return this.historico;
    }

    public Personalidade getPersonalidade() {
        return this.personalidade;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }
}


