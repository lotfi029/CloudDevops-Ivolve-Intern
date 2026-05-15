# Lab 12: Managing Configuration and Sensitive Data

This lab separates non-sensitive database settings into a ConfigMap and sensitive credentials into a Kubernetes Secret.

## Repository Contents

- `configmap.yml`: Defines `mysql-config` in the `ivolve` namespace.
- `secret.yml`: Defines `mysql-secret` in the `ivolve` namespace.

## ConfigMap Values

- `DB_HOST`: `mysql-0.mysql-headless.ivolve.svc.cluster.local`
- `DB_USER`: `appuser`

## Secret Values

The Secret stores base64-encoded values:

- `DB_PASSWORD`: `apppassword`
- `MYSQL_ROOT_PASSWORD`: `rootpassword`

## Steps

```bash
kubectl apply -f configmap.yml
kubectl apply -f secret.yml
```

## Verification

```bash
kubectl get configmap mysql-config -n ivolve -o yaml
kubectl get secret mysql-secret -n ivolve -o yaml
```

To decode a secret value:

```bash
kubectl get secret mysql-secret -n ivolve -o jsonpath='{.data.DB_PASSWORD}' | base64 --decode
```
