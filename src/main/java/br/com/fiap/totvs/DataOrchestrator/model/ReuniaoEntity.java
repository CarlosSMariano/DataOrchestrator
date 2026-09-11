package br.com.fiap.totvs.DataOrchestrator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ReuniaoEntity (
        Long id,
        String titulo,
        LocalDateTime data,
        String textoTranscricao,
        String statusProcesso,
        Double riscoChurn,
        String clienteId
){
}
