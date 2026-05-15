# 1. Create named volume for Nginx logs
docker volume create nginx_logs

# Verify it exists at default path
ls /var/lib/docker/volumes/nginx_logs/

# 2. Create directory for bind mount
mkdir -p ~/nginx-bind/html

# 3. Create custom HTML file
echo "<h1>Hello from Bind Mount</h1>" > ~/nginx-bind/html/index.html

# 4. Run Nginx with volume + bind mount
docker run -d --name nginx-test \
  -p 80:80 \
  -v nginx_logs:/var/log/nginx \
  -v ~/nginx-bind/html:/usr/share/nginx/html \
  nginx

# 5. Verify Nginx is serving your custom page
curl http://localhost
# Expected: <h1>Hello from Bind Mount</h1>

# 6. Modify the HTML on the host (live update — no container restart needed)
echo "<h1>Updated from Bind Mount!</h1>" > ~/nginx-bind/html/index.html
curl http://localhost
# Expected: <h1>Updated from Bind Mount!</h1>

# 7. Verify logs are in the volume
sudo ls /var/lib/docker/volumes/nginx_logs/_data/
# Should see: access.log  error.log

# 8. Delete the volume (stop container first)
docker stop nginx-test
docker rm nginx-test
docker volume rm nginx_logs