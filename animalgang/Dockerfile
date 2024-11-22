# Etapa de build
FROM maven:3.8.6-openjdk-17-slim AS build

# Atualiza o repositório de pacotes e instala as dependências necessárias
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk

# Copia os arquivos da aplicação para o contêiner
COPY . /app

# Define o diretório de trabalho
WORKDIR /app

# Compila a aplicação usando Maven e gera o JAR
RUN mvn clean package -DskipTests

# Etapa final
FROM openjdk:17-jdk-slim

# Exponha a porta que a aplicação vai rodar
EXPOSE 8080

# Copia o JAR gerado da etapa de build para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
