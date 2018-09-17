#Devops
Projeto devops - Softbank

#Instalação do Maven
sudo apt-get install maven

#Instalção do Docker
sudo apt-get install docker
sudo apt-get install docker-compose

#Processo de build (Executar no diretório do pom.xml)
sudo mvn clean package -DskipTests dockerfile:build (Gera os artefatos de publicação, e imagem Docker)

#Criando o banco de dados
sudo docker run -it --name docker-postgres -e POSTGRES_DB=db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres postgres:10.4

#Linkando os containers
sudo docker run -it --link docker-postgres -p 8080:8080 softbank/devops-app

#Executando o Jenkins
java -jar jenkins.war --httpPort=8180

#Acessando 
http://localhost:8080/registration
http://localhost:8080/


