# Sistema de Gestão de Doações para ONGs

## Descrição

O **Sistema de Gestão de Doações para ONGs** é uma aplicação desenvolvida para facilitar a administração e o acompanhamento de doações realizadas por usuários a organizações não-governamentais. O sistema possibilita o cadastro de ONGs, o registro de doações, o gerenciamento de usuários doadores e a geração de relatórios estatísticos, além de oferecer integração com APIs de pagamento e automações com Python para relatórios.

## Funcionalidades

- **Cadastro de ONGs**
    - CRUD completo para gerenciamento de organizações parceiras.
    - Categorização por área (Educação, Saúde, Meio Ambiente, etc.).

- **Gerenciamento de Doações**
    - Registro e histórico de doações realizadas.
    - Integração opcional com APIs de pagamento (ex.: PagSeguro, Stripe).

- **Gestão de Doadores**
    - Cadastro e gerenciamento dos usuários que realizam doações.
    - Visualização do histórico de doações.

- **Relatórios e Estatísticas**
    - Geração de relatórios detalhados por ONG, período e usuário.
    - Ranking de ONGs mais apoiadas.

- **APIs RESTful**
    - Endpoints para CRUD de ONGs, doações e usuários.
    - Endpoints para consultas específicas (ex.: histórico de doações).

- **Autenticação e Permissões (Opcional)**
    - Diferentes perfis de acesso: doador, administrador de ONG e administrador do sistema.

- **Automação com Python (Opcional)**
    - Scripts para geração e exportação automática de relatórios (Excel, PDF).

## Tecnologias Utilizadas

- **Backend**: Java, Spring Boot
- **Banco de Dados**: PostgreSQL
- **Documentação de API**: Swagger/OpenAPI
- **Testes**: JUnit, Mockito
- **Automação**: Python (para scripts de relatórios)
- **Outras**: Dependendo das integrações (ex.: APIs de pagamento)

## Pré-requisitos

Antes de iniciar, verifique se você possui instalado:

- [Java 11 ou superior](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) (ou outro SGBD de sua preferência)

## Contato
Para mais informações, entre em contato via
- [LinkedIn](https://www.linkedin.com/in/mateus-barros13)
- [Email](mb685212@gmail.com)
