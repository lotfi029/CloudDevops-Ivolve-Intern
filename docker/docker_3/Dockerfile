FROM maven:3.9.15-eclipse-temurin-26

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
