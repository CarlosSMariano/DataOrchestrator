package br.com.fiap.totvs.DataOrchestrator.model;

import java.util.ArrayList;
import java.util.List;

public class ResultadoAnalise {
    private String reuniaoId;
    private int scoreOPortunidade;

    //Lista de ocorrencia de risco
    private List<RiscoEncontrado> risco = new ArrayList<>();

    //Classe interna para estruturar risco
    private record RiscoEncontrado(String termo, String contexto){};

    public void addContextoRisco(String termo, String contexto){
        this.risco.add(new RiscoEncontrado(termo, contexto));
    }

    public List<RiscoEncontrado> getRisco() {
        return risco;
    }

    public String getReuniaoId() {
        return reuniaoId;
    }

    public void setReuniaoId(String reuniaoId) {
        this.reuniaoId = reuniaoId;
    }

    public int getScoreOPortunidade() {
        return scoreOPortunidade;
    }

    public void addOPortunidade(int scoreOPortunidade) {
        this.scoreOPortunidade += scoreOPortunidade;
    }

    public void setRisco(List<RiscoEncontrado> risco) {
        this.risco = risco;
    }
}
