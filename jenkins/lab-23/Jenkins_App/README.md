# Jenkins Shared Library App

This is the Spring Boot application used by Lab 23 with the Jenkins shared-library pipeline.

## Contents

- `pom.xml`: Maven configuration using Spring Boot `3.2.0` and Java `17`.
- `Dockerfile`: Runs the packaged Spring Boot JAR.
- `src/main/java/com/example/demo/DemoApplication.java`: Application entry point and `/` endpoint.
- `k8s/deployment.yaml`: Kubernetes Deployment and ClusterIP Service.

## Local Build

```bash
mvn test
mvn package -DskipTests
docker build -t ivolve-shared-lib-app:local .
docker run --rm -p 8080:8080 ivolve-shared-lib-app:local
```

Verify:

```bash
curl http://localhost:8080
```

Expected response:

```text
Hello from Dockerized Spring Boot!
```
