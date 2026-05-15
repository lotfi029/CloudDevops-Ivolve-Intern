# Lab 22: Jenkins Pipeline for Application Deployment

This lab builds a Spring Boot application with Maven, creates a Docker image, pushes it to Docker Hub, updates a Kubernetes manifest, and deploys the app to Kubernetes from Jenkins.

## Repository Contents

- `Jenkinsfile`: Declarative Jenkins pipeline.
- `Jenkins_App/pom.xml`: Maven Spring Boot project using Java `17`.
- `Jenkins_App/Dockerfile`: Runtime image that runs `target/demo-0.0.1-SNAPSHOT.jar`.
- `Jenkins_App/src/main/java/com/example/demo/DemoApplication.java`: Spring Boot app exposing `/`.
- `Jenkins_App/k8s/deployment.yaml`: Kubernetes Deployment and ClusterIP Service.

## Pipeline Stages

1. `Run Unit Test`: runs `mvn test`.
2. `Build App`: runs `mvn package -DskipTests`.
3. `Build Docker Image`: builds `${DOCKERHUB_USER}/ivolve-jenkins-app:${BUILD_NUMBER}`.
4. `Push Image to DockerHub`: logs in with Jenkins credentials and pushes the image.
5. `Delete Image Locally`: removes the local image from the Jenkins node.
6. `Update deployment.yaml`: updates the Kubernetes image tag in `Jenkins_App/k8s/deployment.yaml`.
7. `Deploy to K8s`: runs `kubectl apply`.

## Jenkins Credentials

Create these credentials in Jenkins:

- `dockerhub-creds`: Username and password/token for Docker Hub.
- Kubernetes access: configure `kubectl` on the Jenkins agent, or add kubeconfig handling to the pipeline if your Jenkins setup requires it.

## Jenkins Job Setup

1. Create a new Pipeline job.
2. Select `Pipeline script from SCM`.
3. Set SCM to Git and point it to this repository.
4. Set `Script Path` to:

```text
jenkins/lab-22/Jenkinsfile
```

5. Make sure the Jenkins node has:
   - Java and Maven
   - Docker CLI and Docker daemon access
   - `kubectl` configured for the target cluster

## Kubernetes Setup

Create the namespace if it does not exist:

```bash
kubectl create namespace ivolve
```

The pipeline updates and applies:

```text
Jenkins_App/k8s/deployment.yaml
```

## Verification

```bash
kubectl get deploy,svc -n ivolve
kubectl get pods -n ivolve -l app=ivolve-jenkins-app
```

To test the service locally:

```bash
kubectl port-forward svc/ivolve-jenkins-app-service -n ivolve 8080:8080
curl http://localhost:8080
```

Expected response:

```text
Hello from Dockerized Spring Boot!
```

## Notes

Replace `YOUR_DOCKERHUB_USERNAME` in the manifest before manual use. During Jenkins runs, the pipeline replaces the image line with the pushed build tag.
