# Projeto Contask - Guia de Uso com TestContainers

## Visão Geral
Contask é uma aplicação Spring Boot para gerenciamento de tarefas. Este projeto utiliza PostgreSQL como banco de dados e implementa TestContainers para testes de integração.

## Tecnologias Utilizadas
- Java 23
- Spring Boot 3.3.5
- PostgreSQL
- Flyway para migração de banco de dados
- Lombok e MapStruct
- TestContainers para testes de integração

## O que é TestContainers?
TestContainers é uma biblioteca Java que permite criar containers Docker temporários para testes de integração. Isso possibilita testar a aplicação contra dependências reais (como bancos de dados) sem a necessidade de mockups ou configurações complexas de ambiente.

### Vantagens do TestContainers:
- **Ambientes isolados**: Cada teste executa em um container isolado
- **Realismo**: Testes contra implementações reais das dependências
- **Portabilidade**: Funciona em qualquer ambiente com Docker
- **Facilidade**: Configuração automática de containers para testes

### Como TestContainers funciona no projeto
No Contask, o TestContainers é utilizado para criar um container PostgreSQL durante a execução dos testes de integração. Isso permite testar a aplicação com um banco de dados real, garantindo que as operações de banco de dados funcionem conforme esperado.

### Configuração no projeto
O TestContainers está configurado no `pom.xml`:

```xml
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>postgresql</artifactId>
    <scope>test</scope>
</dependency>
```

## Como executar testes com TestContainers
### Pré-requisitos
- Docker instalado e em execução
- JDK 23 instalado
- Maven instalado

### Executando testes
Para executar os testes com TestContainers, use o comando Maven:

```bash
./mvnw test
```

### Exemplo de teste com TestContainers
```java
@SpringBootTest
@Testcontainers
public class IntegrationTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void contextLoads() {
        // Seu teste aqui
    }
}
```

## Executando o Projeto
Para executar o projeto completo:

```bash
./mvnw spring-boot:run
```

## Contribuindo
Para contribuir com o projeto, siga os seguintes passos:

1. Clone o repositório
2. Crie uma branch para sua feature
3. Adicione seus testes usando TestContainers
4. Envie um pull request

## Licença
Este projeto está licenciado sob a Licença Apache 2.0.
