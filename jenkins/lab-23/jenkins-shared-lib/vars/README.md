# Shared Library Steps

This folder contains the global variable steps used by the Lab 23 Jenkins shared library.

## Steps

- `runUnitTest.groovy`: Runs `mvn test`.
- `buildApp.groovy`: Runs `mvn package -DskipTests`.
- `buildImage.groovy`: Builds a Docker image from the app directory.
- `scanImage.groovy`: Runs a Trivy vulnerability scan.
- `pushImage.groovy`: Logs in to Docker Hub and pushes the image.
- `removeImageLocally.groovy`: Removes the image from the Jenkins agent.
- `deployOnK8s.groovy`: Applies a Kubernetes manifest with `kubectl`.
