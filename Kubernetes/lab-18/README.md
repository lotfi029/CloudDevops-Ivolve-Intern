# Lab 18: Control Pod-to-Pod Traffic with NetworkPolicy

This lab restricts inbound traffic to MySQL so only pods labeled `app: nodejs` in the same namespace can connect to port `3306`.

## Repository Contents

- `network-policy.yaml`: Defines the `allow-app-to-mysql` NetworkPolicy.

## Policy Summary

- Namespace: `ivolve`
- Target pods: `app: mysql`
- Policy type: `Ingress`
- Allowed source pods: `app: nodejs`
- Allowed port: TCP `3306`

## Steps

```bash
kubectl apply -f network-policy.yaml
```

## Verification

```bash
kubectl describe networkpolicy allow-app-to-mysql -n ivolve
kubectl get networkpolicy -n ivolve
```

## Notes

NetworkPolicy enforcement requires a CNI plugin that supports NetworkPolicies, such as Calico, Cilium, or Antrea. Some simple local clusters may not enforce the policy until a compatible CNI is installed.
