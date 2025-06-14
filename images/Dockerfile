# Etapa de build
FROM ubuntu:latest AS BUILD

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

# Etapa de runtime
FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]
