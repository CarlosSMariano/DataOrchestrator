package br.com.fiap.totvs.DataOrchestrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
