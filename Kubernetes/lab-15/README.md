kubectl apply -f nodejs-deployment.yaml

# Note: Only 1 pod will run (namespace quota = 2 pods, mysql uses 1)
kubectl get pods -n ivolve
kubectl get svc nodejs-service -n ivolve