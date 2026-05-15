# Lab 16: Kubernetes Init Container for Database Setup

This lab adds an init container that waits for MySQL, creates the `ivolve` database, creates the application user, grants privileges, and only then allows the Node.js container to start.

## Repository Contents

- `nodejs-deployment.yaml`: Init container snippet for the Node.js Deployment.

## What the Init Container Does

- Uses image `mysql:5.7`.
- Reads database host/user/password values from `mysql-config` and `mysql-secret`.
- Waits until MySQL responds to `SELECT 1`.
- Creates database `ivolve` if it does not exist.
- Creates user `appuser` if it does not exist.
- Grants privileges on `ivolve.*`.

## Usage

Add the `initContainers` block from `nodejs-deployment.yaml` under:

```yaml
spec:
  template:
    spec:
      initContainers:
```

Then apply the completed Deployment manifest:

```bash
kubectl apply -f nodejs-deployment.yaml
```

## Verification

```bash
kubectl get pods -n ivolve -l app=nodejs
kubectl describe pod -n ivolve -l app=nodejs
kubectl exec -it mysql-0 -n ivolve -- mysql -uroot -prootpassword -e "SHOW DATABASES; SELECT user, host FROM mysql.user;"
```

## Dependencies

MySQL from Lab 14 and the configuration/secret resources from Lab 12 must exist first.
