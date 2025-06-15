# Estágio de build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio de produção
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar


# Etapa de runtime
FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar","--spring.profiles.active=prod"]
