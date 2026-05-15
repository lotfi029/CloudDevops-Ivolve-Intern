# Kubernetes Manifest

This folder contains the Kubernetes resources used by the Lab 22 Jenkins pipeline.

## File

- `deployment.yaml`: Creates the `ivolve-jenkins-app` Deployment and `ivolve-jenkins-app-service` ClusterIP Service in the `ivolve` namespace.

## Apply Manually

```bash
kubectl create namespace ivolve
kubectl apply -f deployment.yaml
kubectl get deploy,svc -n ivolve
```

The Jenkins pipeline updates the `image:` field before applying the manifest.
