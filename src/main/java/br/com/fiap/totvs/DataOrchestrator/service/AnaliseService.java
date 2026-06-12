package br.com.fiap.totvs.DataOrchestrator.service;

import br.com.fiap.totvs.DataOrchestrator.model.*;
import br.com.fiap.totvs.DataOrchestrator.repository.MemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnaliseService {

    @Autowired
    private MemoriaRepository repo;

    public ResultadoAnalise processarReuniao(Reuniao reuniao){
        if (repo.buscarReuniao(reuniao.id())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Reunião já processada anteriormente.");
        }

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

    public List<ResultadoAnalise> obterRelatorio(){
        return repo.buscarTodos();
    }
}
