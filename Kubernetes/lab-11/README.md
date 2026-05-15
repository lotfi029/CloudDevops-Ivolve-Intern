# Create namespace

kubectl apply -f namespace

# Apply resource quota (max 2 pods)

kubectl apply -f resourcequota

# Verify quota

kubectl describe resourcequota pod-quota -n ivolve
