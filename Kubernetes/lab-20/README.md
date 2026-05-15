# Create Service Account

kubectl create serviceaccount jenkins-sa -n ivolve

# Create a secret for the SA token (K8s 1.24+)

cat <<EOF | kubectl apply -f -
apiVersion: v1
kind: Secret
metadata:
name: jenkins-sa-token
namespace: ivolve
annotations:
kubernetes.io/service-account.name: jenkins-sa
type: kubernetes.io/service-account-token
EOF

# Retrieve the token

kubectl get secret jenkins-sa-token -n ivolve \
 -o jsonpath='{.data.token}' | base64 --decode

kubectl apply -f rbac.yaml

# Validate: list pods (should succeed)

kubectl auth can-i list pods --as=system:serviceaccount:ivolve:jenkins-sa -n ivolve

# → yes

# Validate: delete pods (should fail)

kubectl auth can-i delete pods --as=system:serviceaccount:ivolve:jenkins-sa -n ivolve

# → no
