kubectl apply -f prometheus-node-exporter.yaml

# Validate pod is on each node
kubectl get pods -n monitoring -o wide

# Confirm metrics are exposed (from any node IP)
NODE_IP=$(kubectl get nodes -o jsonpath='{.items[0].status.addresses[0].address}')
curl http://$NODE_IP:9100/metrics | head -20