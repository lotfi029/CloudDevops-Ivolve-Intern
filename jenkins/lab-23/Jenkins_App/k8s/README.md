# Kubernetes Manifest

This folder contains the Kubernetes resources used by the Lab 23 shared-library Jenkins pipeline.

## File

- `deployment.yaml`: Creates the `ivolve-shared-lib-app` Deployment and `ivolve-shared-lib-app-service` ClusterIP Service in the `ivolve` namespace.

## Apply Manually

```bash
kubectl create namespace ivolve
kubectl apply -f deployment.yaml
kubectl get deploy,svc -n ivolve
```

The Jenkins pipeline updates the `image:` field before deployment.
