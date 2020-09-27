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
  
 -CI/CD
   - Ao fazer um commit, ira ser realizado um build do projeto Maven e rodar os testes através do github action
   - Ao criar um release, ira ser criado um pacote jar, uma imagem docker, e sera feito o deploy em um servidor kubernetes na google cloud.
   - Link para acesso http://35.244.193.158/
