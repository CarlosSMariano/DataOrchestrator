package br.com.fiap.totvs.DataOrchestrator.repository;

import br.com.fiap.totvs.DataOrchestrator.model.ResultadoAnalise;

import java.util.ArrayList;
import java.util.List;

public class MemoriaRepository {
    private List<ResultadoAnalise> bancoDeDados =  new ArrayList<>();

    public void salvar(ResultadoAnalise resultadoAnalise){
        this.bancoDeDados.add(resultadoAnalise);
    }

    public List<ResultadoAnalise> buscarTodos(){
        return bancoDeDados;
    }
}
