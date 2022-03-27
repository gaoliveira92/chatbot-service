1. Infos
Nome: chatbot-service
Objetivo: Criação de protocolos de atendimento e registro do atendimento.

2. Projeto
O projeto se encontra no GitHub na seguinte url:
https://github.com/gaoliveira92/chatbot-service

3.1. Como baixar o projeto

Entre na pasta do projeto no GitHub > Botão Code > Copiar a url HTTPS
Entre no terminal > crie uma pasta workspace na raíz > execute o seguinte comando:
$ git clone https://github.com/gaoliveira92/chatbot-service.git

O projeto será copiado na máquina.

3.2. Rodar o projeto
Para abrir o projeto, é recomendado ter uma IDE, caso não tenha uma de sua preferência, é possível baixar o IntelliJ Community. Para rodar o projeto também será necessário a instalação e configuração do Java 11 e do Docker.
Intellij: https://www.jetbrains.com/pt-br/idea/download/#section=mac
Java: https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html
Docker: https://docs.docker.com/get-docker/

Ao abrir o projeto no Intellij, o arquivo do Gradle, o build.gradle.kts iniciará o build das dependências do projeto, aguardar até terminar com sucesso.
Agora será necessário fazer login no Docker da máquina. Após o login, rodar no terminal o seguinte comando:
$ docker-compose up -d
E o banco de dados será criado no Docker, como pode ser visto abaixo:

Ainda no terminal, buildar e rodar o projeto com os seguintes comandos:
$ ./gradlew build
$./gradlew bootRun

Projeto rodando!

AWS
O serviço está rodando na AWS também, e pode ser acessado pelo endpoint do Swagger: http://ec2-18-218-116-66.us-east-2.compute.amazonaws.com:8080/swagger-ui.html#/protocol-historic-controller

Usuário: service
Senha: service

Consumo da API

O serviço possui quatro chamadas:
Para a execução é possível utilizar a ferramenta Postman:


5.1. Criar um novo protocolo de atendimento
Endpoint:
Local:
http://localhost:8080/protocol/new/${cpf}
Aws:
http://ec2-18-218-116-66.us-east-2.compute.amazonaws.com:8080/protocol/new/${cpf}
Tipo de chamada: GET
Header:
Authorization: Basic c2VydmljZTpzZXJ2aWNl

5.2. Salvar o histórico de conversa
Endpoint:
Local:
http://localhost:8080/protocol/historic
Aws: http://ec2-18-218-116-66.us-east-2.compute.amazonaws.com:8080/protocol/historic
Tipo de chamada: POST
Header:
Authorization: Basic c2VydmljZTpzZXJ2aWNl

Body:
{
"protocol":"1247620220319T182215916649",
"queryResult": {
"allRequiredParamsPresent": "true",
"fulfillmentMessages": "teste",
"fulfillmentText": "Poderia informar seu CPF ou Número do Convenio?",
"intent": {
"displayName": "gostaria de ajuda",
"name": "projects/newagent-uc9l/agent/intents/ae6c62e4-a8bf-4615-acbf-c104802d2002"
},
"intentDetectionConfidence": "0.4426844",
"languageCode": "pt-br",
"parameters": {
"location": "",
"url": ""
},
"queryText": "estou come duvidas sobre agendamento de consultas"
},
"responseId": "g6e6c10e-5a35-4809-9883-773437533ff9-40ef389b"
}

5.3. Pesquisar o histórico por protocolo
Endpoint:
Local:
http://localhost:8080/protocol/historic/${protocol}
Aws: http://ec2-18-218-116-66.us-east-2.compute.amazonaws.com:8080/protocol/historic/${protocol}
Tipo de chamada: GET
Header: 
Authorization: Basic c2VydmljZTpzZXJ2aWNl

5.4. Pesquisar o histórico por cpf
Endpoint:
Local:
http://localhost:8080/protocol/${cpf}
Aws:
http://ec2-18-218-116-66.us-east-2.compute.amazonaws.com:8080/protocol/${cpf}
Tipo de chamada: GET
Header:
Authorization: Basic c2VydmljZTpzZXJ2aWNl





