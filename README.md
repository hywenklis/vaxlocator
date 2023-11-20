# Documentação da Aplicação VaxLocator

## Visão Geral
Aplicação para obtenção de nota no projeto integrador CESMAC.

A aplicação fornece informações sobre pontos de vacinação com base em códigos postais. A estrutura da aplicação é organizada em vários pacotes, cada um responsável por diferentes aspectos da funcionalidade.

## Componentes Principais

### 1. `AdminController`

Controlador responsável por endpoints relacionados à atualização de informações.

#### Métodos Principais:

- `findAddressInformation`: Recupera informações de endereço usando a API OpenCageData.
- `findEstablishmentsInformation`: Recupera informações de estabelecimentos usando a API Demas.
- `findAddress`: Recupera informações de endereço no banco de dados.
- `findAllEstablishment`: Recupera todas as informações de estabelecimentos no banco de dados.

### 2. `VaxLocatorController`

Controlador responsável por endpoints relacionados aos pontos de vacinação.

#### Métodos Principais:

- `findAll`: Recupera informações de pontos de vacinação com base em um código postal.

## Fluxo de Funcionamento

1. **Consulta de Coordenadas Atuais:**
    - `AdminController` utiliza `openCageDataService` para obter informações de endereço usando a API OpenCageData.

2. **Consulta de Estabelecimentos:**
    - `AdminController` utiliza `demasService` para recuperar informações de estabelecimentos usando a API Demas.

3. **Consulta de Endereço no Banco de Dados:**
    - `AdminController` utiliza `addressService` para recuperar informações de endereço no banco de dados.

4. **Consulta de Estabelecimentos no Banco de Dados:**
    - `AdminController` utiliza `establishmentService` para recuperar todas as informações de estabelecimentos no banco de dados.

5. **Consulta de Pontos de Vacinação:**
    - `VaxLocatorController` utiliza `vaccinationPoints` para recuperar informações sobre pontos de vacinação com base em um código postal.

## Endpoints

### Admin Controller

- **GET /v1/admin/info/open/cage/data**
    - Parâmetros:
        - `apiKey`: Chave da API para autenticação.
        - `postalCode`: Código postal para consulta de endereço.
    - Retorna: `OpenCageDataDto`.

- **GET /v1/admin/info/demas/gov**
    - Parâmetros:
        - `unityTypeCode`: Código representando o tipo de unidade.
        - `ufCode`: Código representando o estado.
        - `limit`: Número máximo de resultados a serem recuperados (máximo = 20).
        - `offset`: Deslocamento para paginação.
    - Retorna: `EstablishmentsInfoDto`.

- **GET /v1/admin/info/address**
    - Parâmetros:
        - `postalCode`: Código postal para consulta de endereço.
    - Retorna: `AddressDomainDto`.

- **GET /v1/admin/info/establishments**
    - Retorna: Lista de `EstablishmentDomainDto`.

### Vax Locator Controller

- **GET /v1/vax/locator/details**
    - Parâmetros:
        - `postalCode`: Código postal para consulta de pontos de vacinação.
    - Retorna: `EstablishmentsInfoDomainDto`.
## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring JPA
- Feign Client
- MapStruct
- PostgreSQL
- Docker Compose
- Lombok
- Swagger - OpenAPI Springdoc

## Diagrama de Contexto - C4 Model

![Documentação](https://github.com/hywenklis/vaxlocator/blob/main/diagrama.png) 
