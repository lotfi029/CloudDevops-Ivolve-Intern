# Stage 1: Build
FROM maven:3.9.15-eclipse-temurin-26 AS builder

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:26-jre

WORKDIR /app

COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]