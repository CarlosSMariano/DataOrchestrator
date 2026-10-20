package br.com.fiap.totvs.DataOrchestrator.model;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.sql.Date;

@Table("CLIENTE")
public record ClienteEntity(

        @Id
        @Column("ID_CLI")
        Long id,

        @Column("NOME_CLI")
        String nome,

        @Column("DATA_CADAST")
        Date dataCadast
) {
}
