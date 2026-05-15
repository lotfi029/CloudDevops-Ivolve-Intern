# Jenkins Labs

This directory contains the Jenkins module for the iVolve Cloud DevOps Accelerator labs.

## Labs

- `lab-21`: Jenkins role-based authorization with admin and viewer roles.
- `lab-22`: Jenkins deployment pipeline for a Maven Spring Boot application.
- `lab-23`: Jenkins agent pipeline using a reusable shared library.

## Prerequisites

- Jenkins LTS running with administrator access.
- Docker installed on Jenkins agents that build images.
- Maven and Java available for the Spring Boot application builds.
- `kubectl` configured when deploying to Kubernetes.
- Docker Hub credentials stored in Jenkins as `dockerhub-creds`.

## Notes

The application in Labs 22 and 23 is Maven-based, so the pipelines use `mvn test` and `mvn package -DskipTests`.
