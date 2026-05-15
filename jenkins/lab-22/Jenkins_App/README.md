# Jenkins App

This is the Spring Boot application used by Lab 22.

## Contents

- `pom.xml`: Maven configuration using Spring Boot `3.2.0` and Java `17`.
- `Dockerfile`: Builds a runtime image from the packaged JAR.
- `src/main/java/com/example/demo/DemoApplication.java`: Application entry point and `/` endpoint.
- `k8s/deployment.yaml`: Kubernetes Deployment and ClusterIP Service.

## Local Build

```bash
mvn test
mvn package -DskipTests
docker build -t ivolve-jenkins-app:local .
docker run --rm -p 8080:8080 ivolve-jenkins-app:local
```

Verify:

```bash
curl http://localhost:8080
```

Expected response:

```text
Hello from Dockerized Spring Boot!
```
