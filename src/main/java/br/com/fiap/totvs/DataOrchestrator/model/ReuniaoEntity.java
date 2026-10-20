package br.com.fiap.totvs.DataOrchestrator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table("REUNIAO")
public record ReuniaoEntity (

        @Id
        @Column("ID_REUN")
        Long id,

        @Column("TITULO_REUN")
        String titulo,

        @Column("DATA_REUN")
        LocalDate data,

        @Column("TEXT_TRANS")
        String textoTrans,

        @Column("STATUS_PROCESS")
        String statusProcess,

        @Column("RISCO_CHURN")
        Double riscoChurn,

        @Column("CLIENTE_ID_CLI")
        Long clienteId
) {
}

