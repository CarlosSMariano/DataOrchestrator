package br.com.fiap.totvs.DataOrchestrator.service;

import br.com.fiap.totvs.DataOrchestrator.model.*;
import br.com.fiap.totvs.DataOrchestrator.repository.MemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnaliseService {

    @Autowired
    private MemoriaRepository repo;

    public ResultadoAnalise processarReuniao(Reuniao reuniao){
        ResultadoAnalise resultado = new ResultadoAnalise();
        resultado.setReuniaoId(reuniao.id());

        List<RegraAnalise> regras = new ArrayList<>();
        regras.add(new RegraRisco());
        regras.add(new RegraOportunidade());

        for (RegraAnalise regra : regras) {
            regra.analisar(reuniao,  resultado);
        }

        repo.salvar(resultado);

        return resultado;
    }

    public List<ResultadoAnalise> obterRelatorio(Reuniao reuniao){
        return repo.buscarTodos();
    }
}
