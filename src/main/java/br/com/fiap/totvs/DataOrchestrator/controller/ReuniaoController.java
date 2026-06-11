package br.com.fiap.totvs.DataOrchestrator.controller;

import br.com.fiap.totvs.DataOrchestrator.model.ResultadoAnalise;
import br.com.fiap.totvs.DataOrchestrator.model.Reuniao;
import br.com.fiap.totvs.DataOrchestrator.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reunioes")
public class ReuniaoController {

    @Autowired
    private AnaliseService service;

    @PostMapping
    public ResultadoAnalise inserirReuniao(@RequestBody Reuniao reuniao) {
        return service.processarReuniao(reuniao);
    }

    @GetMapping
    public List<ResultadoAnalise> listarReuniao(){
        return service.obterRelatorio();
    }
}
