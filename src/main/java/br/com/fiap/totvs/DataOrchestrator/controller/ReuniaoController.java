package br.com.fiap.totvs.DataOrchestrator.controller;

import br.com.fiap.totvs.DataOrchestrator.model.ResultadoAnalise;
import br.com.fiap.totvs.DataOrchestrator.model.Reuniao;
import br.com.fiap.totvs.DataOrchestrator.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reunioes")
public class ReuniaoController {

    @Autowired
    private AnaliseService service;

    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "Tudo certo!");
        response.put("code", "200");
        response.put("message", "API DataOrchestrator está operando normalmente");
        return response;
    }
    @PostMapping
    public ResultadoAnalise inserirReuniao(@RequestBody Reuniao reuniao) {
        return service.processarReuniao(reuniao);
    }

    @GetMapping
    public List<ResultadoAnalise> listarReuniao(){
        return service.obterRelatorio();
    }
}
