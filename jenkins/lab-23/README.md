# Lab 23: CI/CD Pipeline with Jenkins Agents and Shared Libraries

This lab refactors the Jenkins deployment pipeline into reusable shared-library steps and runs the pipeline on a dedicated Jenkins agent labeled `jenkins-slave`.

## Repository Contents

- `Jenkinsfile`: Pipeline that imports `@Library('jenkins-shared-lib')`.
- `Jenkins_App/pom.xml`: Maven Spring Boot project using Java `17`.
- `Jenkins_App/Dockerfile`: Runtime image for the packaged Spring Boot JAR.
- `Jenkins_App/k8s/deployment.yaml`: Kubernetes Deployment and ClusterIP Service.
- `jenkins-shared-lib/vars/runUnitTest.groovy`: Runs Maven tests.
- `jenkins-shared-lib/vars/buildApp.groovy`: Packages the Maven app.
- `jenkins-shared-lib/vars/buildImage.groovy`: Builds the Docker image.
- `jenkins-shared-lib/vars/scanImage.groovy`: Scans the image with Trivy.
- `jenkins-shared-lib/vars/pushImage.groovy`: Pushes the image to Docker Hub.
- `jenkins-shared-lib/vars/removeImageLocally.groovy`: Removes the local image.
- `jenkins-shared-lib/vars/deployOnK8s.groovy`: Applies a Kubernetes manifest.

## Shared Library Structure

```text
jenkins-shared-lib/
└── vars/
    ├── runUnitTest.groovy
    ├── buildApp.groovy
    ├── buildImage.groovy
    ├── scanImage.groovy
    ├── pushImage.groovy
    ├── removeImageLocally.groovy
    └── deployOnK8s.groovy
```

## Pipeline Stages

1. `RunUnitTest`: calls `runUnitTest(APP_DIR)`.
2. `BuildApp`: calls `buildApp(APP_DIR)`.
3. `BuildImage`: calls `buildImage(IMAGE_NAME, IMAGE_TAG, APP_DIR)`.
4. `ScanImage`: calls `scanImage(IMAGE_NAME, IMAGE_TAG)`.
5. `PushImage`: calls `pushImage(IMAGE_NAME, IMAGE_TAG, 'dockerhub-creds')`.
6. `RemoveImageLocally`: calls `removeImageLocally(IMAGE_NAME, IMAGE_TAG)`.
7. `UpdateManifest`: updates the image field in the Kubernetes manifest.
8. `DeployOnK8s`: calls `deployOnK8s(DEPLOYMENT_FILE)`.

## Jenkins Agent Setup

1. Go to `Manage Jenkins` > `Nodes` > `New Node`.
2. Create a permanent agent named or labeled `jenkins-slave`.
3. Configure:
   - Remote root directory: `/home/jenkins/agent`
   - Launch method: SSH
   - Host: your agent VM IP
   - Credentials: SSH private key
4. Install or configure these tools on the agent:
   - Java and Maven
   - Docker CLI and Docker daemon access
   - `kubectl`
   - Network access to Docker Hub and the Kubernetes cluster

## Shared Library Setup

In Jenkins, go to `Manage Jenkins` > `System` > `Global Pipeline Libraries` and add:

- Name: `jenkins-shared-lib`
- Default version: `main`
- Retrieval method: Git
- Project repository: the repository that contains `jenkins-shared-lib`

If you keep the shared library in this same training repository, point the library configuration at the repo and use the `jenkins/lab-23/jenkins-shared-lib` content as the library source when copying it to a dedicated shared-library repo.

## Jenkins Credentials

Create this credential:

- `dockerhub-creds`: Docker Hub username and password/token.

Make sure the Jenkins agent can authenticate to Kubernetes with `kubectl`.

## Jenkins Job Setup

1. Create a new Pipeline job.
2. Select `Pipeline script from SCM`.
3. Set SCM to this repository.
4. Set `Script Path` to:

```text
jenkins/lab-23/Jenkinsfile
```

5. Replace `YOUR_DOCKERHUB_USERNAME` in the Jenkinsfile or parameterize it before running.

## Verification

```bash
kubectl get deploy,svc -n ivolve
kubectl get pods -n ivolve -l app=ivolve-shared-lib-app
```

To test the deployed app:

```bash
kubectl port-forward svc/ivolve-shared-lib-app-service -n ivolve 8080:8080
curl http://localhost:8080
```

Expected response:

```text
Hello from Dockerized Spring Boot!
```

## Notes

The Trivy scan uses `--exit-code 0`, so vulnerabilities are reported without failing the pipeline. Change it to `--exit-code 1` if you want high or critical findings to block deployment.
