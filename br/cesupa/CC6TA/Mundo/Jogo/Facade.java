package br.cesupa.CC6TA.Mundo.Jogo;

import br.cesupa.CC6TA.Mundo.Agente.Agente;
import br.cesupa.CC6TA.Mundo.Jogo.ExceptionsDoJogo.ObjetoJaCriadoException;
import br.cesupa.CC6TA.Mundo.Jogo.ExceptionsDoJogo.PosicaoReservadaParaAgenteException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Pedro
 */
public class Facade {

    private Partida partida;
    private Agente agente;

    public Facade() {
        partida = new Partida();
        agente = new Agente(getPartida().getMapa());

    }

    public void criaBuraco(int posicaoX, int posicaoY) {
        try {
            getPartida().criaBuraco(posicaoX, posicaoY);
        } catch (PosicaoReservadaParaAgenteException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ObjetoJaCriadoException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void criaWumpus(int posicaoX, int posicaoY) {
        try {
            getPartida().criaWumpus(posicaoX, posicaoY);
        } catch (PosicaoReservadaParaAgenteException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ObjetoJaCriadoException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void criaOuro(int posicaoX, int posicaoY) {
        try {
            getPartida().criaOuro(posicaoX, posicaoY);
        } catch (PosicaoReservadaParaAgenteException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ObjetoJaCriadoException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarPartida() {
        getAgente().iniciarAventura();
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

}
