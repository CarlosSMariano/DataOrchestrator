package br.com.fiap.totvs.DataOrchestrator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Esta classe representa o JSON bruto

@JsonIgnoreProperties(ignoreUnknown = true)
public record Reuniao(
        @JsonProperty("ID_METTING") String id,
        @JsonProperty("ANON_TRANSCRICAO") String transcricao
) {
}
