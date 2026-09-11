package br.com.fiap.totvs.DataOrchestrator.exception;

import br.com.fiap.totvs.DataOrchestrator.model.RespostaAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControleGlobalDeExceptions {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RespostaAPI> handleException(RuntimeException e) {
        RespostaAPI resposta = new RespostaAPI("ERRO AO PROCESSAR REQUISIÇÃO: " + e.getMessage(), java.time.LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }
}
