# Lab 15: Node.js Application Deployment with ClusterIP Service

This lab deploys the Node.js application to Kubernetes and exposes it internally with a ClusterIP Service.

## Repository Contents

- `nodejs-deployment.yaml`: Defines the `nodejs-app` Deployment and `nodejs-service` Service.

## Resource Summary

- Namespace: `ivolve`
- Deployment: `nodejs-app`
- Desired replicas: `2`
- Service: `nodejs-service`
- Service type: `ClusterIP`
- App port: `3000`
- Image placeholder: `YOUR_DOCKERHUB_USERNAME/ivolve-app:latest`
- Log mount: `app-logs-pvc` mounted at `/app/logs`
- Config source: `mysql-config`
- Secret source: `mysql-secret`

## Steps

Before applying, replace the image placeholder with your Docker Hub image:

```yaml
image: YOUR_DOCKERHUB_USERNAME/ivolve-app:latest
```

Then apply the manifest:

```bash
kubectl apply -f nodejs-deployment.yaml
```

## Verification

```bash
kubectl get deploy nodejs-app -n ivolve
kubectl get pods -n ivolve -l app=nodejs
kubectl get svc nodejs-service -n ivolve
```

## Dependencies

Apply Labs 11, 12, 13, and 14 first so the namespace, configuration, secret, log PVC, and MySQL service exist.

## Notes

The namespace quota from Lab 11 allows only two pods. If MySQL is already running, only one Node.js pod may be scheduled until the quota is increased.
