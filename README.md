# MyGreeting API 🚀

Uma API de saudação simples e moderna feita com **Spring Boot 3** e **Java 17**.

## Tecnologias
- Java 17
- Spring Boot 3.3.1
- Spring Web
- Springdoc OpenAPI (Swagger)
- JUnit 5 / MockMvc

## Como Executar
O projeto já conta com o Maven Wrapper (`mvnw`), portanto não é necessário ter o Maven instalado em sua máquina.

1. Navegue até a pasta do projeto:
   ```bash
   cd Jpmarinw/mygreeting
   ```

2. Execute o comando para iniciar a aplicação:
   - **No Windows:**
     ```cmd
     .\mvnw.cmd spring-boot:run
     ```

## Endpoints

A aplicação roda nativamente na porta `8080`.

- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **API (Default):** [http://localhost:8080/greeting](http://localhost:8080/greeting)
- **API (Com Parâmetro):** [http://localhost:8080/greeting?name=Brazuca](http://localhost:8080/greeting?name=Brazuca)

## Testes Automatizados

Para rodar a suíte de testes:
```cmd
.\mvnw.cmd test
```
