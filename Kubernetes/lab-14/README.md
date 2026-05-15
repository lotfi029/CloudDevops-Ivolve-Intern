kubectl apply -f mysql-statefulset.yaml

# Wait for pod to be Running
kubectl get pods -n ivolve -w

# Confirm DB is operational
kubectl exec -it mysql-0 -n ivolve -- mysql -uroot -prootpassword -e "SHOW DATABASES;"