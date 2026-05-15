kubectl apply -f nodejs-deployment.yaml

# Verify resource settings

kubectl describe pod -l app=nodejs -n ivolve | grep -A8 "Limits\|Requests"

# Monitor real-time usage (requires metrics-server)

kubectl top pod -n ivolve

# Install metrics-server if missing:

# kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
