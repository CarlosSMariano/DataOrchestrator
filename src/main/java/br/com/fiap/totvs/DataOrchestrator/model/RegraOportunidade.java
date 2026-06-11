package br.com.fiap.totvs.DataOrchestrator.model;

import java.util.List;

public class RegraOportunidade extends RegraAnalise{
    private final List<String> termosOportunidade = List.of(
            // Intenção Direta de Compra/Negócio
            "comprar", "contratar", "orçamento", "investimento",
            "aprovado", "viabilidade", "proposta", "orçar", "negociar",

            // Expansão e Ecossistema
            "novo módulo", "integrar", "integração", "automatizar",
            "plataforma", "escalar", "crescimento", "otimizar", "centralizar",

            // Produtos TOTVS
            "protheus", "rm", "fluig", "totvs one", "carol", "gooddata"
    );


    @Override
    public void analisar(Reuniao reuniao, ResultadoAnalise resultado) {
        String texto = reuniao.transcricao().toLowerCase();

        for(String termo : termosOportunidade){
            if (texto.contains(termo)){
               resultado.addOPortunidade(15);
            }
        }
    }
}
