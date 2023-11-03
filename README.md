# Iniciando

Aplicação que permite que o cliente cifre as suas próprias músicas.

## Tecnologias e referencias de documentação
Este projeto utiliza as seguintes tecnologias:

* [Java 17](https://www.oracle.com/br/java/)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web.security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.flyway)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#io.validation)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)
* [Lombok](https://projectlombok.org/)
* [PostgreSQL](https://www.postgresql.org/docs/current/release-16.html)
* [H2 Database](https://www.h2database.com/html/main.html)

## Informações de Usuário e Perfil

- Usuários:
    * Login: admin, Senha: admin123
    * Login: moderator, Senha: moderator123
    * Login: user, Senha: user123

- Perfil:
    * ADMIN: Acesso aos verbos do Http (Get, Post, Delete, Update)
    * USER: Acesso restrito apenas ao verbo Get do Http
