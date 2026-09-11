package br.com.fiap.totvs.DataOrchestrator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReuniaoInput(
        @JsonProperty("ID_MEETING") String idReuniao,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @JsonProperty("DT_MEETING")
        Date dtReuniao,
        @JsonProperty("STATUS_MEETING") String statusProcesso,
        @JsonProperty("CODT") String nomeCliente,
        @JsonProperty("ANON_TRANSCRICAO") String textoTranscricao

) {
}
