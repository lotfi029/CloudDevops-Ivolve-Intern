# Lab 9: Containerized Node.js and MySQL Stack Using Docker Compose

This lab runs a Node.js Express application with a MySQL database using Docker Compose. The app waits for the `ivolve` database, serves a static frontend, exposes health/readiness endpoints, and writes access logs to a bind-mounted logs directory.

## Repository Contents

- `kubernets-app/docker-compose.yml`: Compose stack with `app` and `db` services.
- `kubernets-app/Dockerfile`: Node.js `18-alpine` image for the app.
- `kubernets-app/server.js`: Express server, MySQL connection retry logic, health checks, static frontend, and access logging.
- `kubernets-app/db.js`: Database helper file.
- `kubernets-app/package.json`: Node.js dependencies and start script.
- `kubernets-app/frontend/index.html`: Static iVolve frontend page.
- `kubernets-app/frontend/assets/ivolve-logo.png`: Frontend image asset used by the static page.

## Compose Summary

The `app` service builds from the local Dockerfile and maps port `3000:3000`. The `db` service uses `mysql:8.0`, creates the `ivolve` database, and stores data in the named volume `db_data`.

## Steps

```bash
cd kubernets-app

docker compose up -d
```

If your Docker installation still uses the legacy Compose command, use:

```bash
docker-compose up -d
```

## Verification

```bash
curl http://localhost:3000
curl http://localhost:3000/health
curl http://localhost:3000/ready
docker compose exec app ls /app/logs
```

The frontend should load from `/`, health and readiness should return success after MySQL is ready, and `/app/logs/access.log` should be created.

## Push Image to Docker Hub

```bash
docker login
docker tag kubernets-app-app YOUR_DOCKERHUB_USERNAME/ivolve-app:latest
docker push YOUR_DOCKERHUB_USERNAME/ivolve-app:latest
```

Adjust the local image name if `docker compose images` shows a different generated name.

## Cleanup

```bash
docker compose down -v
```
