# Lab 6: Managing Docker Environment Variables

This lab demonstrates three ways to provide environment variables to a Flask application: inline runtime variables, an environment file, and variables baked into a production Docker image.

## Repository Contents

- `Docker-3/app.py`: Flask app that reads `APP_MODE` and `APP_REGION`.
- `Docker-3/Dockerfile`: Base image for runtime-provided environment variables.
- `Docker-3/Dockerfile.prod`: Production image with `ENV APP_MODE=production` and `ENV APP_REGION=canada-west`.
- `Docker-3/staging.env`: Example environment file for staging.

## Steps

```bash
cd Docker-3

docker build -t flask-env-app .

docker run -d --name dev-container \
  -e APP_MODE=development \
  -e APP_REGION=us-east \
  -p 8081:8080 \
  flask-env-app

docker run -d --name staging-container \
  --env-file staging.env \
  -p 8082:8080 \
  flask-env-app

docker build -t flask-prod-app -f Dockerfile.prod .
docker run -d --name prod-container -p 8083:8080 flask-prod-app
```

## Verification

```bash
curl http://localhost:8081
curl http://localhost:8082
curl http://localhost:8083
```

Expected responses show the active mode and region for each container.

## Cleanup

```bash
docker stop dev-container staging-container prod-container
docker rm dev-container staging-container prod-container
```
