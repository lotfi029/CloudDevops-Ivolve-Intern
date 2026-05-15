# Lab 13: Persistent Storage Setup for Application Logging

This lab creates persistent storage for application logs using a hostPath PersistentVolume and a PersistentVolumeClaim in the `ivolve` namespace.

## Repository Contents

- `pv-logs.yaml`: Defines both `app-logs-pv` and `app-logs-pvc`.

## Resource Summary

- PersistentVolume: `app-logs-pv`
- PersistentVolumeClaim: `app-logs-pvc`
- Capacity: `1Gi`
- Access mode: `ReadWriteMany`
- Reclaim policy: `Retain`
- Host path: `/mnt/app-logs`

## Steps

```bash
kubectl apply -f pv-logs.yaml
```

## Verification

```bash
kubectl get pv app-logs-pv
kubectl get pvc app-logs-pvc -n ivolve
```

Both resources should show `STATUS` as `Bound`.

## Notes

This storage is consumed by the Node.js application Deployment in later labs through the `/app/logs` mount path.
