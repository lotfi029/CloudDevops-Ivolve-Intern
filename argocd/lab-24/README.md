# Lab 24: GitOps Workflow with ArgoCD

This lab implements a GitOps deployment workflow. Jenkins builds the application image, pushes it to Docker Hub, updates the Kubernetes manifest in Git, and ArgoCD automatically syncs the new desired state to Kubernetes.

## Repository Contents

- `Jenkinsfile`: CI pipeline that builds, pushes, updates the manifest, and pushes back to Git.
- `argocd-app.yaml`: ArgoCD `Application` resource.
- `k8s/deployment.yaml`: Example Deployment and ClusterIP Service watched by ArgoCD.

## Step 1: Install ArgoCD

```bash
kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
kubectl get pods -n argocd -w
```

Access the UI:

```bash
kubectl port-forward svc/argocd-server -n argocd 8080:443
```

Get the initial admin password:

```bash
kubectl get secret argocd-initial-admin-secret -n argocd -o jsonpath="{.data.password}" | base64 --decode
```

## Step 2: Configure Jenkins

Create these Jenkins credentials:

- `dockerhub-creds`: Docker Hub username and password/token.
- `github-creds`: GitHub username and token.

Update placeholders in `Jenkinsfile`:

- `YOUR_USER`
- `YOUR_REPO`
- `GITOPS_REPO`

## Step 3: Create ArgoCD Application

Update placeholders in `argocd-app.yaml`:

- `repoURL`
- `path`
- `targetRevision`

Apply the application:

```bash
kubectl create namespace ivolve
kubectl apply -f argocd-app.yaml
```

## Verification

```bash
kubectl get application ivolve-app -n argocd
kubectl get deploy,svc -n ivolve
```

Expected ArgoCD state:

```text
Synced / Healthy
```

## Notes

In GitOps, Jenkins should not directly apply manifests to the cluster. Jenkins changes Git, and ArgoCD reconciles the cluster from Git.
