package br.com.fiap.totvs.DataOrchestrator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClienteEntity(
        Long id,
       @JsonProperty("NOME_CLI") String nome,
        @JsonProperty("DATA_CADAST") Date dataCadast
) {
}
