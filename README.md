Precisa de:
  - JDK11
  - Maven
  - Postgres
  
Considerações: 
 
- Sobre o postgres:
  - Pra rodar o backend é preciso adicionar o seu IPV4 publico no arquivo .gituhub/workflows/maven.yml e fazer um commit, isso ira adicionar seu IP na lista de Ips, disponiveis      para acessar o banco de dados. Isso apenas enquanto não é configurado a conexão por SSl.

- Quando subir a aplicação com o servidor postgres up, a própria app ja sobe as tabelas automaticamente no bd

- Tem o arquivo data.sql em src/main/resources só como um exemplo de teste se voce quiser rodar uma query no pgadmin

- Indo para seu localhost, uma vez que a app esteja up, só vai ter o index com um hello world e um link para uma pagina que printa os nomes dos membros
  que foram inseridos no banco de dados
  
 -Infra
   - Ao realizar qualquer commit na branch master 3 Actions ( github CI/CD) são executadas.
      - Build que valida se o novo código esta de acordo com os testes unitarios e faz o deploy no Google Kubernates Engine caso tenha passado.
      - Build simples responsável por fazer testes e cadastrar IPs para acesso a base de dados.
      - Build e analise do SonarCloud
   - Link para acesso do backend http://35.190.128.246:8181/ (swagger disponível)
   - Link para acesso do frontend http://www.pikazio.com/
   - Link para acesso do Sonar Back https://sonarcloud.io/dashboard?id=LucasPicazio_Proj-Integ-SI
   - Link para acesso do Sonar Front https://sonarcloud.io/dashboard?id=LucasPicazio_Proj-Integ-SI-Front
