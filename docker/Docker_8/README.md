# Lab 8: Custom Docker Network for Microservices

This lab demonstrates service discovery on a custom Docker network using a small Flask frontend and backend. The frontend calls the backend by container name, which only works when both containers share the same user-defined network.

## Repository Contents

- `Docker5/Dockerfile.frontend`: Builds the Flask frontend image.
- `Docker5/Dockerfile.backend`: Builds the Flask backend image.
- `Docker5/frontend/app.py`: Calls `http://backend:5000`.
- `Docker5/frontend/requirements.txt`: Frontend Python dependencies.
- `Docker5/backend/app.py`: Returns `Hello from Backend!`.

## Steps

```bash
cd Docker5

docker build -t frontend-img -f Dockerfile.frontend .
docker build -t backend-img -f Dockerfile.backend .

docker network create ivolve-network

docker run -d --name backend --network ivolve-network backend-img
docker run -d --name frontend1 --network ivolve-network -p 5001:5000 frontend-img
docker run -d --name frontend2 -p 5002:5000 frontend-img
```

## Verification

The frontend on the custom network should reach the backend:

```bash
curl http://localhost:5001
```

Expected response includes:

```text
Frontend received: Hello from Backend!
```

The frontend on the default network should not resolve the `backend` container name:

```bash
curl http://localhost:5002
```

Expected response:

```text
Could not connect to backend.
```

## Cleanup

```bash
docker stop backend frontend1 frontend2
docker rm backend frontend1 frontend2
docker network rm ivolve-network
```
