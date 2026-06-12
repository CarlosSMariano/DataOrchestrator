# DataOrchestrator TOTVS🚀

## Descrição do Projeto
O **DataOrchestrator** é uma solução de backend capaz de processar transcrições de reuniões, identificar padrões de risco (possível Churn) e oportunidades de negócio (Upsell/Cross-sell) através de regras de negócio polimórficas.

Este projeto foi desenhado sob os princípios de **Domain Driven Design (DDD)**, utilizando Spring Boot para orquestrar o fluxo de dados entre o processamento de texto e a camada de visualização do utilizador.

### Principais Funcionalidades
- **Análise Polimórfica:** Processamento dinâmico de regras (`RegraRisco` e `RegraOportunidade`).
- **Extração de Contexto:** Identificação inteligente de trechos relevantes dentro da transcrição.
- **API RESTful:** Endpoints padronizados com códigos de status HTTP semânticos (`200 OK`, `409 Conflict`).
- **Arquitetura Limpa:** Separação clara entre Controllers, Services, Repositories e Models.

## Estrutura do Projeto
O projeto está organizado seguindo o padrão MVC:
- `br.com.fiap.totvs.DataOrchestrator.model`: Entidades e classes de regras (Herança).
- `br.com.fiap.totvs.DataOrchestrator.repository`: Camada de persistência em memória (ArrayList).
- `br.com.fiap.totvs.DataOrchestrator.service`: Orquestração de negócio e análise.
- `br.com.fiap.totvs.DataOrchestrator.controller`: Endpoints da API REST.

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Maven** (Gerenciamento de dependências)

## Como Executar
1. Certifique-se de ter o JDK 25.
2. Clone o repositório ou descompacte o arquivo `.zip` da entrega.
3. Importe o projeto como um projeto **Maven** na sua IDE (IntelliJ ou Eclipse).
4. Execute a classe `DataOrchestratorApplication`.
5. A API estará disponível em `http://localhost:8080/api/reunioes`.

## 🔗 Endpoints Principais
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/api/reunioes/status` | Verifica a saúde da API |
| `POST` | `/api/reunioes` | Processa uma nova transcrição |
| `GET` | `/api/reunioes` | Lista todos os relatórios processados |

## 🤝 Contribuidores

- Carlos Eduardo Sanches Mariano - RM 561756
- Gabriel Henrique Borges Hombris - RM 566553
- Icaro Machado de Carvalho - RM 572804
- Nicolas Guinante - RM 570222

---
*Projeto desenvolvido para a disciplina de Domain Driven Desing (java) - FIAP.*