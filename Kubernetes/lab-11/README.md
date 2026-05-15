# Lab 11: Namespace Management and Resource Quota Enforcement

This lab creates an isolated namespace named `ivolve` and applies a resource quota that limits the namespace to two pods.

## Repository Contents

- `namespace.yml`: Creates the `ivolve` namespace.
- `resourcequota.yml`: Creates `pod-quota` with `pods: "2"`.

## Steps

```bash
kubectl apply -f namespace.yml
kubectl apply -f resourcequota.yml
```

## Verification

```bash
kubectl get namespace ivolve
kubectl describe resourcequota pod-quota -n ivolve
```

Expected quota hard limit:

```text
pods: 2
```

## Notes

Because the namespace allows only two pods, later labs that deploy MySQL plus a two-replica Node.js Deployment may only run part of the desired workload until the quota is changed.
