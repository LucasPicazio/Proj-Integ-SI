Precisa de:
  - JDK11
  - Maven
  - Postgres
  
Considerações: 
 
- Sobre o postgres:
  - Pra rodar a aplicação no momento precisa de um servidor postgres rodando localmente 
    com um banco de dados de nome spring-demo e senha sakujo (tudo isso é configuravel pelo application.properties)

- Quando subir a aplicação com o servidor postgres up, a própria app ja sobe as tabelas automaticamente no bd

- Tem o arquivo data.sql em src/main/resources só como um exemplo de teste se voce quiser rodar uma query no pgadmin

- Indo para seu localhost, uma vez que a app esteja up, só vai ter o index com um hello world e um link para uma pagina que printa os nomes dos membros
  que foram inseridos no banco de dados
