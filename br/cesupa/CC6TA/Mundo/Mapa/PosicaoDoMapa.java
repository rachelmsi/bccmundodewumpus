package br.cesupa.CC6TA.Mundo.Mapa;

import br.cesupa.CC6TA.Mundo.ObjetosDeTerreno.ObjetoDoTerreno;

/**
 * @author Pedro
 */
public class PosicaoDoMapa {

    private int posicaoX, posicaoY;
    private ObjetoDoTerreno objetoDoTerreno;
    private boolean resplendor, fedor, brisa;
    private boolean visitadoPeloAgente;
    private boolean casaSegura;
    private boolean possibilidadeDeWumpus;
    private boolean possibilidadeDeBuraco;

    //construtor
    /**
     * Define a posicao x e y da posicao do mapa, seus atributos(brisa, esplendor, fedor)
     * como false e define o objeto do terreno como null
     * @param posicaoX define a posicao x da posicao do mapa
     * @param posicaoY define a posicao y da posicao do mapa
     */
    public PosicaoDoMapa(int posicaoX, int posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.resplendor = this.fedor = this.brisa = false;
        this.objetoDoTerreno = null;
        this.visitadoPeloAgente = false;
        this.casaSegura = false;
        this.possibilidadeDeWumpus = false;
        this.possibilidadeDeBuraco = false;
    }

    // ######### sets e gets #########
    // os sets e gets de buraco, wumpus, casaSegura e visitadoPeloAgente são diferentes do normal
    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public ObjetoDoTerreno getObjetoDoTerreno() {
        return objetoDoTerreno;
    }

    public void setObjetoDoTerreno(ObjetoDoTerreno objetoDoTerreno) {
        this.objetoDoTerreno = objetoDoTerreno;
    }

    public boolean isResplendor() {
        return resplendor;
    }

    public void setResplendor(boolean resplendor) {
        this.resplendor = resplendor;
    }

    public boolean isFedor() {
        return fedor;
    }

    public void setFedor(boolean fedor) {
        this.fedor = fedor;
    }

    public boolean isBrisa() {
        return brisa;
    }

    public void setBrisa(boolean brisa) {
        this.brisa = brisa;
    }

    public boolean isVisitadoPeloAgente() {
        return visitadoPeloAgente;
    }

    public void setVisitadoPeloAgente(boolean visitadoPeloAgente) {
        if (visitadoPeloAgente == true) {
            this.visitadoPeloAgente = visitadoPeloAgente;
            this.casaSegura = true;
            this.possibilidadeDeWumpus = false;
            this.possibilidadeDeBuraco = false;
        } else {
            this.visitadoPeloAgente = visitadoPeloAgente;
        }
    }

    public boolean isCasaSegura() {
        return casaSegura;
    }

    public void setCasaSegura(boolean casaSegura) {
        if (casaSegura == true) {
            this.casaSegura = casaSegura;
            this.possibilidadeDeWumpus = false;
            this.possibilidadeDeBuraco = false;
        } else {
            this.casaSegura = casaSegura;
        }

    }

    public boolean isPossibilidadeDeWumpus() {
        return possibilidadeDeWumpus;
    }

    public void setPossibilidadeDeWumpus(boolean possibilidadeDeWumpus) {
        this.possibilidadeDeWumpus = possibilidadeDeWumpus;
    }

    public boolean isPossibilidadeDeBuraco() {
        return possibilidadeDeBuraco;
    }

    public void setPossibilidadeDeBuraco(boolean possibilidadeDeBuraco) {
        this.possibilidadeDeBuraco = possibilidadeDeBuraco;
    }
}
