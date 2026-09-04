package br.com.fiap.totvs.DataOrchestrator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Reuniao(
        @JsonProperty("ID_MEETING") String id,
        @JsonProperty("ANON_TRANSCRICAO") String transcricao
) {
}
