# DataOrchestrator 🚀

## Descrição do Projeto
O **DataOrchestrator** é uma solução de inteligência conversacional desenvolvida para a TOTVS, focada em transformar transcrições de reuniões não estruturadas em insights acionáveis em tempo real. O sistema atua como o núcleo de processamento (Back-end) que identifica oportunidades de negócio e sinais de risco (churn) através de um motor de regras inteligente.

Este projeto foi desenhado sob os princípios de **Domain Driven Design (DDD)**, utilizando Spring Boot para orquestrar o fluxo de dados entre o processamento de texto e a camada de visualização do utilizador.

## Funcionalidades Principais
- **Motor de Análise por Regras:** Utilização de herança e polimorfismo para processar diferentes tipos de inteligência (Risco vs Oportunidade) de forma modular.
- **Processamento em Tempo Real:** Arquitetura pronta para integração via API/WebSocket, permitindo a análise imediata de transcrições.
- **Relatório de Inteligência:** Consolidação de métricas extraídas que servem como base para modelos preditivos de Data Science.

## Estrutura do Projeto
O projeto está organizado seguindo o padrão MVC:
- `br.com.fiap.totvs.DataOrchestrator.model`: Entidades e classes de regras (Herança).
- `br.com.fiap.totvs.DataOrchestrator.repository`: Camada de persistência em memória (ArrayList).
- `br.com.fiap.totvs.DataOrchestrator.service`: Orquestração de negócio e análise.
- `br.com.fiap.totvs.DataOrchestrator.controller`: Endpoints da API REST.

## Tecnologias Utilizadas
- **Java 25+**
- **Spring Boot**
- **Maven** (Gerenciamento de dependências)

## Como Executar
1. Certifique-se de ter o JDK 25.
2. Clone o repositório ou descompacte o arquivo `.zip` da entrega.
3. Importe o projeto como um projeto **Maven** na sua IDE (IntelliJ ou Eclipse).
4. Execute a classe `DataOrchestratorApplication`.
5. A API estará disponível em `http://localhost:8080/api/reunioes`.

## Exemplo de Endpoint (POST)
Para testar o processamento, envie um JSON para `/api/reunioes`:
```json
{
    "id": "12345",
    "transcricao": "O time de RH está sofrendo com o sistema manual, queremos trocar pelo Protheus."
}
```

## 👥 Autores

- Carlos Eduardo Sanches Mariano - RM 561756
- Gabriel Henrique Borges Hombris - RM 566553
- Icaro Machado de Carvalho - RM 572804
- Nicolas Guinante - RM 570222

Projeto desenvolvido como parte do Challenge FIAP 2026 - Engenharia de Software.