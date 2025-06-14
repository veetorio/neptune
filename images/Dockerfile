# Etapa de build
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar api.jar
ENTRYPOINT ["java", "-jar", "api.jar"]
