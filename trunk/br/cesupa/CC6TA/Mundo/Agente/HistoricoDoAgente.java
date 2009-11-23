package br.cesupa.CC6TA.Mundo.Agente;

public class HistoricoDoAgente {
    private String historico;

    public HistoricoDoAgente() {
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
