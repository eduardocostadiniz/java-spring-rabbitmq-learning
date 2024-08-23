# Java Spring RabbitMQ Learning

Este projeto tem como intuito, aprender mais sobre mensageria entre aplicações Java Spring e RabbitMQ.  

> Para acelerar o aprendizado, esse projeto consta o produtor e o consumidor de mensagens no mesmo pacote e projeto.

### *Principais ferramentas*

**Linguagem Principal:** Java (JDK 21)  
**Framework:** Spring Boot 3  
**Gerenciador de Dependências/Build:** Gradle  

### *Configuração do Ambiente de Desenvolvimento*

###### JAVA
Baixar e instalar o Java JDK versão 21 [DOWNLOAD](https://www.oracle.com/br/java/technologies/downloads/#java21)  

###### RABBIT MQ
Para criar um container do RabbitMQ local, vamos usar o docker compose. Precisamos entrar na pasta raiz do projeto e executar o comando abaixo:

```sh
docker-compose up
```


###### Variáveis de Ambiente do Projeto
Para executar o projeto, precisaremos de preencher algumas variáveis de ambiente. No projeto existe um arquivo modelo chamado `.env.sample`, nele contém as variáveis que precisam ser preenchidas. Basta duplicar esse arquivo e renomeá-lo para `.env` que o Spring Boot vai procurar os valores e preencher no arquivo `application.properties`. Exemplo de preenchimento:  

```.env
RABBITMQ_HOST=localhost
RABBITMQ_PORT=5672
RABBITMQ_USER=user
RABBITMQ_PASS=password
```
