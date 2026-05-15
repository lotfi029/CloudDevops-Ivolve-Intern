# Jenkins Shared Library

This folder contains reusable Jenkins Pipeline steps for Lab 23.

## Structure

```text
vars/
├── runUnitTest.groovy
├── buildApp.groovy
├── buildImage.groovy
├── scanImage.groovy
├── pushImage.groovy
├── removeImageLocally.groovy
└── deployOnK8s.groovy
```

## Usage

Configure this folder as a Jenkins Global Pipeline Library named:

```text
jenkins-shared-lib
```

Then import it from a Jenkinsfile:

```groovy
@Library('jenkins-shared-lib') _
```

Each file in `vars/` exposes a step with the same name as the file.
