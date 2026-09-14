# DataOrchestrator TOTVS 🚀

## Descrição do Projeto
O **DataOrchestrator** é uma solução de backend desenvolvida em Spring Boot para processar transcrições de reuniões, gerenciar clientes e orquestrar fluxos de dados corporativos (com foco em análise de risco de Churn).

O projeto adota uma arquitetura em camadas estruturada em Controllers, Services, DAOs (Data Access Object) e Models, conectando-se a um banco de dados relacional Oracle.

### Principais Funcionalidades
- **Gestão de Clientes:** CRUD completo de clientes com validação de duplicidade e exclusão em cascata controlada por transações (`JDBC` com `setAutoCommit(false)`).
- **Gestão e Processamento de Reuniões:** Cadastro, listagem, atualização e remoção de reuniões com suporte a transcrições e análise de risco de churn.
- **API RESTful Completa:** Endpoints padronizados com códigos de status HTTP semânticos e tratamento global de exceções (`@RestControllerAdvice`).
- **Persistência com JDBC Nativo:** Conexão direta e segura com banco de dados Oracle utilizando `PreparedStatement`.

## Estrutura do Projeto
O projeto está organizado em pacotes modulares:
- `br.com.fiap.totvs.DataOrchestrator.config`: Configuração de conexão com o banco de dados.
- `br.com.fiap.totvs.DataOrchestrator.controller`: Endpoints da API REST (`ClienteController`, `ReuniaoController`).
- `br.com.fiap.totvs.DataOrchestrator.dao`: Camada de persistência e comunicação SQL com o banco Oracle.
- `br.com.fiap.totvs.DataOrchestrator.exception`: Tratamento global de exceções.
- `br.com.fiap.totvs.DataOrchestrator.model`: Records e entidades de representação de dados.
- `br.com.fiap.totvs.DataOrchestrator.service`: Regras de negócio e orquestração.

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Oracle Database** (Driver JDBC)
- **Maven** (Gerenciamento de dependências)

## Como Executar
1. Certifique-se de ter o JDK 17 ou superior instalado e uma instância do Oracle Database configurada (ex: Oracle Database Free em `localhost:1521/FREEPDB1` com as credenciais adequadas).
2. Clone o repositório ou descompacte o arquivo `.zip` da entrega.
3. Importe o projeto como um projeto **Maven** na sua IDE (IntelliJ IDEA ou Eclipse).
4. Execute a classe principal `DataOrchestratorApplication`.
5. A API estará pronta para receber requisições em `http://localhost:8080`.

## 🔗 Endpoints Principais

### Clientes (`/api/clientes`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/api/clientes/status` | Verifica a saúde do endpoint de clientes |
| `GET` | `/api/clientes` | Lista todos os clientes cadastrados |
| `GET` | `/api/clientes/{id}` | Busca um cliente específico por ID |
| `POST` | `/api/clientes` | Cadastra um novo cliente |
| `PUT` | `/api/clientes/{id}` | Atualiza os dados de um cliente |
| `DELETE` | `/api/clientes/{id}` | Remove um cliente e suas reuniões vinculadas |

### Reuniões (`/api/reunioes`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/api/reunioes/status` | Verifica a saúde do endpoint de reuniões |
| `GET` | `/api/reunioes` | Lista todas as reuniões cadastradas |
| `GET` | `/api/reunioes/{id}` | Busca uma reunião específica por ID |
| `POST` | `/api/reunioes` | Cadastra/processa uma nova reunião |
| `PUT` | `/api/reunioes/{id}` | Atualiza uma reunião existente |
| `DELETE` | `/api/reunioes/{id}` | Remove uma reunião |

## 🤝 Contribuidores

- Carlos Eduardo Sanches Mariano - RM 561756
- Gabriel Henrique Borges Hombris - RM 566553
- Icaro Machado de Carvalho - RM 572804
- Nicolas Guinante - RM 570222

---
*Projeto desenvolvido para a disciplina de Domain Driven Design (Java) - FIAP.*
