package br.com.fiap.totvs.DataOrchestrator.controller;

import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import br.com.fiap.totvs.DataOrchestrator.model.RespostaAPI;
import br.com.fiap.totvs.DataOrchestrator.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    private record StatusResponse(String status, String mensagem, String timestamp){};

    @GetMapping("/status")
    public ResponseEntity<ClienteController.StatusResponse> status() {
        ClienteController.StatusResponse status = new ClienteController.StatusResponse(
                "Online",
                "API DataOrchestrator está operando normalmente",
                java.time.LocalTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @GetMapping
    public ResponseEntity<ArrayList<ClienteEntity>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> listarCliente(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.buscarCliente(id));
    }

    @PostMapping
    public ResponseEntity<RespostaAPI> inserirCliente(@RequestBody ClienteEntity cliente) {
        clienteService.inserirCliente(cliente);
        RespostaAPI resposta = new RespostaAPI("Cliente cadastrado.", java.time.LocalTime.now().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaAPI> deletarCliente(@PathVariable long id) {
        clienteService.deletarCliente(id);
        RespostaAPI resposta = new RespostaAPI("Cliente excluido.", java.time.LocalTime.now().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}
