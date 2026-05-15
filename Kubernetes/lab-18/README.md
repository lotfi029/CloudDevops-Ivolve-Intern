kubectl apply -f network-policy.yaml

# Verify policy
kubectl describe networkpolicy allow-app-to-mysql -n ivolve