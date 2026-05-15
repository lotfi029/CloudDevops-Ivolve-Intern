# Lab 19: Node-Wide Pod Management with DaemonSet

This lab deploys Prometheus Node Exporter as a DaemonSet so one monitoring pod runs on every Kubernetes node.

## Repository Contents

- `prometheus-node-exporter.yaml`: Creates the `monitoring` namespace and the `node-exporter` DaemonSet.

## Resource Summary

- Namespace: `monitoring`
- DaemonSet: `node-exporter`
- Image: `prom/node-exporter:latest`
- Port: `9100`
- Uses `hostNetwork` and `hostPID`
- Mounts host `/proc` and `/sys`
- Tolerates all taints with `operator: Exists`

## Steps

```bash
kubectl apply -f prometheus-node-exporter.yaml
```

## Verification

```bash
kubectl get pods -n monitoring -o wide

NODE_IP=$(kubectl get nodes -o jsonpath='{.items[0].status.addresses[0].address}')
curl http://$NODE_IP:9100/metrics | head -20
```

Expected result: one Node Exporter pod per node, with Prometheus metrics exposed on port `9100`.

## Notes

Because this manifest uses privileged access and host namespaces, use it only in controlled lab environments unless you harden it for production.
