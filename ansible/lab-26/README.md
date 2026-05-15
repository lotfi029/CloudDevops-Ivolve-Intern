# Lab 26: Automated Web Server Configuration Using Ansible Playbooks

This lab uses an Ansible playbook to install Nginx, enable the service, and publish a custom HTML page.

## Repository Contents

- `inventory.ini`: Example managed-node inventory.
- `webserver-playbook.yaml`: Nginx installation and configuration playbook.

## What the Playbook Does

- Installs `nginx`.
- Starts and enables the Nginx service.
- Writes a custom `/var/www/html/index.html`.
- Reloads Nginx.

## Run

Update `inventory.ini`, then execute:

```bash
ansible-playbook -i inventory.ini webserver-playbook.yaml
```

## Verification

```bash
curl http://MANAGED_NODE_IP
```

Expected page content includes:

```html
<h1>Hello from iVolve Ansible Lab!</h1>
```
