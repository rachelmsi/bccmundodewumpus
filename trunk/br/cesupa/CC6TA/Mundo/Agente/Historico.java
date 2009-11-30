package br.cesupa.CC6TA.Mundo.Agente;

public class Historico {
    private String historico;

    public Historico() {
        this.historico = "";
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public void appendHistorico(String historico) {
        this.historico += historico + "\n";
    }
}
