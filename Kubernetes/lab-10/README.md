# Start cluster with 2 nodes (minikube example)
minikube start --nodes=2

# List nodes
kubectl get nodes
# Note the name of the second node (e.g., minikube-m02)

# Taint the worker node
kubectl taint nodes minikube-m02 node=worker:NoSchedule

# Verify taint on all nodes
kubectl describe nodes | grep -A5 "Taints:"