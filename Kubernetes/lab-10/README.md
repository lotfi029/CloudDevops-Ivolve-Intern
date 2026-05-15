# Lab 10: Node Isolation Using Taints in Kubernetes

This lab isolates scheduling on a worker node by applying a `NoSchedule` taint. Pods without a matching toleration will not be scheduled onto the tainted node.

## Prerequisites

- A Kubernetes cluster with at least two nodes.
- `kubectl` configured for the target cluster.
- Minikube is optional but convenient for local testing.

## Steps

```bash
minikube start --nodes=2

kubectl get nodes
kubectl taint nodes minikube-m02 node=worker:NoSchedule
```

Replace `minikube-m02` with the actual worker node name from your cluster.

## Verification

```bash
kubectl describe node minikube-m02 | grep -A5 "Taints:"
```

Expected taint:

```text
node=worker:NoSchedule
```

## Notes

Later Kubernetes labs include tolerations so selected workloads can run on this tainted worker node.
