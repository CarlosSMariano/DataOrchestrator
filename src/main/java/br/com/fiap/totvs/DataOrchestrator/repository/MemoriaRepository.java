package br.com.fiap.totvs.DataOrchestrator.repository;

import br.com.fiap.totvs.DataOrchestrator.model.ResultadoAnalise;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoriaRepository {
    private List<ResultadoAnalise> bancoDeDados =  new ArrayList<>();

    public void salvar(ResultadoAnalise resultadoAnalise){
        this.bancoDeDados.add(resultadoAnalise);
    }

    public boolean buscarReuniao(String id){

        return bancoDeDados.stream().anyMatch(b -> b.getReuniaoId().equals(id));

    }

    public List<ResultadoAnalise> buscarTodos(){
        return bancoDeDados;
    }
}
