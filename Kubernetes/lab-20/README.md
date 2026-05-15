# Lab 20: Securing Kubernetes with RBAC and Service Accounts

This lab grants a Jenkins service account read-only access to pods in the `ivolve` namespace using a Role and RoleBinding.

## Repository Contents

- `rbac.yaml`: Defines the `pod-reader` Role and `jenkins-sa-pod-reader` RoleBinding.

## Resource Summary

- ServiceAccount expected: `jenkins-sa`
- Namespace: `ivolve`
- Role: `pod-reader`
- Allowed resources: `pods`
- Allowed verbs: `get`, `list`
- RoleBinding subject: `system:serviceaccount:ivolve:jenkins-sa`

## Create Service Account and Token

```bash
kubectl create serviceaccount jenkins-sa -n ivolve

cat <<EOF | kubectl apply -f -
apiVersion: v1
kind: Secret
metadata:
  name: jenkins-sa-token
  namespace: ivolve
  annotations:
    kubernetes.io/service-account.name: jenkins-sa
type: kubernetes.io/service-account-token
EOF
```

Retrieve the token:

```bash
kubectl get secret jenkins-sa-token -n ivolve -o jsonpath='{.data.token}' | base64 --decode
```

## Apply RBAC

```bash
kubectl apply -f rbac.yaml
```

## Verification

```bash
kubectl auth can-i list pods --as=system:serviceaccount:ivolve:jenkins-sa -n ivolve
kubectl auth can-i delete pods --as=system:serviceaccount:ivolve:jenkins-sa -n ivolve
```

Expected results:

```text
yes
no
```
