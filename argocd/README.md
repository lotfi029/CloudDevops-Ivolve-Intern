# ArgoCD Labs

This module covers GitOps deployment with ArgoCD.

## Labs

- `lab-24`: GitOps workflow where Jenkins builds and pushes an image, updates Kubernetes manifests in Git, and ArgoCD syncs the cluster from the repository.

## Prerequisites

- Kubernetes cluster with `kubectl` access.
- Jenkins configured with Docker Hub and GitHub credentials.
- Docker available on the Jenkins agent.
- A Git repository containing Kubernetes manifests for ArgoCD to watch.

## Common Commands

Install ArgoCD:

```bash
kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
```

Access the UI:

```bash
kubectl port-forward svc/argocd-server -n argocd 8080:443
```

Get the initial admin password:

```bash
kubectl get secret argocd-initial-admin-secret -n argocd -o jsonpath="{.data.password}" | base64 --decode
```
