# ConfigMap for non-sensitive MySQL config

kubectl apply -f configmap

# Secret for sensitive credentials (values must be base64 encoded)

# echo -n "apppassword" | base64 → YXBwcGFzc3dvcmQ=

# echo -n "rootpassword" | base64 → cm9vdHBhc3N3b3Jk

kubectl apply -f secret

# Verify

kubectl get configmap mysql-config -n ivolve -o yaml
kubectl get secret mysql-secret -n ivolve -o yaml
