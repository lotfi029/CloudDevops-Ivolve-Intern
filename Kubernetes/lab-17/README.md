# Lab 17: Pod Resource Management with Requests and Limits

This lab adds CPU and memory requests/limits to the Node.js container so Kubernetes can make better scheduling decisions and enforce runtime resource boundaries.

## Repository Contents

- `nodejs-deployment.yaml`: Resource snippet for the Node.js container.

## Resource Settings

```yaml
resources:
  requests:
    cpu: "1"
    memory: "1Gi"
  limits:
    cpu: "2"
    memory: "2Gi"
```

## Usage

Add the `resources` block under the `nodejs` container in the Deployment manifest, then apply it:

```bash
kubectl apply -f nodejs-deployment.yaml
```

## Verification

```bash
kubectl describe pod -l app=nodejs -n ivolve | grep -A8 "Limits\|Requests"
kubectl top pod -n ivolve
```

If metrics are unavailable, install metrics-server:

```bash
kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
```

## Notes

Make sure your cluster has enough allocatable CPU and memory for these requests, especially if you are using Minikube or a small local cluster.
