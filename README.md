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

#Instalando o Jenkins
wget -q -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add -
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo apt-get update
sudo apt-get install jenkins

alterar a porta de execução de 8080 para 8081 no arquivo: /etc/default/jenkins	HTTP_PORT=8081
arquivo contendo a senha inicial: /var/lib/jenkins/secrets/initialAdminPassword

#Iniciando o Jenkins
sudo service jenkins start
http://localhost:8081

brunoSoftbank

#Acessando 
http://localhost:8080/registration
http://localhost:8080/


