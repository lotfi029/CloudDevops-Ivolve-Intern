# Ansible Labs

This module covers Ansible automation for server configuration, roles, vault secrets, and dynamic inventory.

## Labs

- `lab-25`: Initial Ansible setup, SSH access, inventory, and ad-hoc commands.
- `lab-26`: Nginx web server automation with a playbook.
- `lab-27`: Structured configuration management with Ansible roles for Docker, kubectl, and Jenkins.
- `lab-28`: Secret management with Ansible Vault and MySQL provisioning.
- `lab-29`: AWS EC2 dynamic inventory and running automation against discovered hosts.

## Prerequisites

- A Linux control node with Ansible installed.
- One or more reachable managed nodes.
- SSH key-based access from the control node to managed nodes.
- Sudo privileges on managed nodes for package installation.

## Common Inventory Format

```ini
[managed_nodes]
managed1 ansible_host=MANAGED_NODE_IP ansible_user=ubuntu ansible_ssh_private_key_file=~/.ssh/ansible_key
```

Replace `MANAGED_NODE_IP` and `ansible_user` with your actual managed-node details.
