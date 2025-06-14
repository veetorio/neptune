# Etapa de build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa de runtime
FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/*.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]
