kubectl apply -f pv-logs.yaml

# Verify binding
kubectl get pv app-logs-pv
kubectl get pvc app-logs-pvc -n ivolve
# Both should show STATUS: Bound