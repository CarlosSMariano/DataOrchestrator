package br.com.fiap.totvs.DataOrchestrator.controller;

import br.com.fiap.totvs.DataOrchestrator.model.RespostaAPI;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoEntity;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoInput;
import br.com.fiap.totvs.DataOrchestrator.service.ReuniaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/reunioes")
public class ReuniaoController {

    @Autowired
    private ReuniaoService service;

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
    public ResponseEntity<RespostaAPI> cadastrarReuniao(@RequestBody ReuniaoInput reuniao) {
          service.inserirNoBanco(reuniao);
          RespostaAPI resposta = new RespostaAPI("Reunião cadastrada com sucesso!", java.time.LocalDateTime.now().toString());
          return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<ArrayList<ReuniaoEntity>> listarReunioes() {
        ArrayList<ReuniaoEntity> lista = service.listarReunioes();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaAPI> deletarReuniao(@PathVariable long id) {
        service.deletarReuniao(id);
        RespostaAPI resposta = new RespostaAPI("Reunião deletada com sucesso!", java.time.LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }



}
