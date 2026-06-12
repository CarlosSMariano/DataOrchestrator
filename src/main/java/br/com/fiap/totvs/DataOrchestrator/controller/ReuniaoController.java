package br.com.fiap.totvs.DataOrchestrator.controller;

import br.com.fiap.totvs.DataOrchestrator.model.ResultadoAnalise;
import br.com.fiap.totvs.DataOrchestrator.model.Reuniao;
import br.com.fiap.totvs.DataOrchestrator.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reunioes")
public class ReuniaoController {

    @Autowired
    private AnaliseService service;

    private record StatusResponse(String status, String mensagem, String timestamp){};

    @GetMapping("/status")
    public ResponseEntity<StatusResponse> status() {
       StatusResponse status = new StatusResponse(
               "Online",
               "API DataOrchestrator está operando normalmente",
               java.time.LocalTime.now().toString()
       );
       return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @PostMapping
    public ResponseEntity<ResultadoAnalise> inserirReuniao(@RequestBody Reuniao reuniao) {
        ResultadoAnalise resultado = service.processarReuniao(reuniao);

        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public List<ResultadoAnalise> listarReuniao(){
        return service.obterRelatorio();
    }
}
