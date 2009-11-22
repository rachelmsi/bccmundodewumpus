package br.cesupa.CC6TA.Mundo.ObjetosDeTerreno;

/**
 *
 * @author Pedro
 */
public enum TipoObjeto {
    WUMPUS, BURACO, OURO;

    public String toString() {
        return this.name().toLowerCase();
    }
}
