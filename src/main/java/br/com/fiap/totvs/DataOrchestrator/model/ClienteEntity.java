package br.com.fiap.totvs.DataOrchestrator.model;

import java.sql.Date;

public record ClienteEntity(
        Long id,
        String nome,
        Date dataCadast
) {
}
