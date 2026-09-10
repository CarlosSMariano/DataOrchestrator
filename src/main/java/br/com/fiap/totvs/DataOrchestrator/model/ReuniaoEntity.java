package br.com.fiap.totvs.DataOrchestrator.model;

import java.time.LocalDate;
import java.util.List;

public record ReuniaoEntity (
        Long id,
        String titulo,
        LocalDate data,
        String textoTranscricao,
        String statusProcesso,
        Double riscoChurn,
        Long clienteId
){
}
