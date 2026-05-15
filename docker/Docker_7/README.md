# Lab 7: Docker Volume and Bind Mount with Nginx

This lab runs Nginx with two storage types: a named volume for logs and a bind mount for website content. The bind mount allows live HTML updates from the host without rebuilding or restarting the container.

## What This Lab Creates

- Named volume: `nginx_logs`
- Host bind mount directory: `~/nginx-bind/html`
- Nginx container: `nginx-test`

## Steps

```bash
docker volume create nginx_logs

mkdir -p ~/nginx-bind/html
echo "<h1>Hello from Bind Mount</h1>" > ~/nginx-bind/html/index.html

docker run -d --name nginx-test \
  -p 80:80 \
  -v nginx_logs:/var/log/nginx \
  -v ~/nginx-bind/html:/usr/share/nginx/html \
  nginx
```

## Verification

```bash
curl http://localhost
```

Expected output:

```html
<h1>Hello from Bind Mount</h1>
```

Update the host file and verify the change appears immediately:

```bash
echo "<h1>Updated from Bind Mount!</h1>" > ~/nginx-bind/html/index.html
curl http://localhost
```

Check logs stored in the named volume:

```bash
sudo ls /var/lib/docker/volumes/nginx_logs/_data/
```

Expected log files include `access.log` and `error.log`.

## Cleanup

```bash
docker stop nginx-test
docker rm nginx-test
docker volume rm nginx_logs
```
