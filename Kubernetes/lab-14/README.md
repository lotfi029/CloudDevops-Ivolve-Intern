# Lab 14: StatefulSet with Headless Service

This lab deploys MySQL as a Kubernetes StatefulSet and exposes it through a headless Service for stable pod DNS.

## Repository Contents

- `mysql-statefulset.yaml`: Defines the `mysql-headless` Service and the `mysql` StatefulSet.

## Resource Summary

- Namespace: `ivolve`
- Service: `mysql-headless`
- StatefulSet: `mysql`
- Replicas: `1`
- Image: `mysql:8.0`
- Stable DNS: `mysql-0.mysql-headless.ivolve.svc.cluster.local`
- Storage: `volumeClaimTemplates` named `mysql-data`
- Scheduling: tolerates `node=worker:NoSchedule`

## Steps

```bash
kubectl apply -f mysql-statefulset.yaml
```

## Verification

```bash
kubectl get pods -n ivolve -w
kubectl get svc mysql-headless -n ivolve
kubectl exec -it mysql-0 -n ivolve -- mysql -uroot -prootpassword -e "SHOW DATABASES;"
```

## Dependencies

Apply Lab 12 first so the `mysql-secret` Secret exists before the StatefulSet starts.
