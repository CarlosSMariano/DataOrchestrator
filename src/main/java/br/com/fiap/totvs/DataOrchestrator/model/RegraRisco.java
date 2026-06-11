package br.com.fiap.totvs.DataOrchestrator.model;

import java.util.List;

public class RegraRisco extends RegraAnalise {

    //Lista de termos que disparam risco:
    private final List<String> termosNegativos = List.of(
            "manual", "trabalhoso", "lento", "dificuldade", "demorado",
            "complexo", "travando", "limitação", "ineficiente", "burocrático",
            "concorrente", "senior", "sap", "migrar", "trocar",
            "orçamento", "pesquisando", "demonstração",
            "insatisfeito", "descontente", "problema", "falha",
            "cancelar", "custo", "abandono", "insuporte"
    );

    @Override
    public void analisar(Reuniao reuniao, ResultadoAnalise resultado) {
        String texto = reuniao.transcricao().toLowerCase();

        for(String termo : termosNegativos){
            if (texto.contains(termo)){
                int index = texto.indexOf(termo);

                String contexto = texto.substring(Math.max(0, index - 20), Math.min(index + 20, texto.length()));
                resultado.addContextoRisco(termo, contexto);
            }
        }
    }
}
