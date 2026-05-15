# Kubernetes Manifests

This folder contains the Kubernetes resources watched by the ArgoCD application in Lab 24.

## File

- `deployment.yaml`: Creates the `ivolve-gitops-app` Deployment and `ivolve-gitops-app-service` ClusterIP Service in the `ivolve` namespace.

## Usage

ArgoCD applies this folder automatically when `argocd-app.yaml` points to the `k8s` path.

Manual apply:

```bash
kubectl create namespace ivolve
kubectl apply -f deployment.yaml
```
