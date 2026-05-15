kubectl apply -f nodejs-deployment.yaml

# Verify DB and user exist
kubectl exec -it mysql-0 -n ivolve -- \
  mysql -uroot -prootpassword -e "SHOW DATABASES; SELECT user, host FROM mysql.user;"