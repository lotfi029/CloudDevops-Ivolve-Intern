# Lab 25: Initial Ansible Configuration and Ad-Hoc Execution

This lab prepares the Ansible control node, configures SSH access to a managed node, creates an inventory file, and runs ad-hoc Ansible commands.

## Repository Contents

- `inventory.ini`: Example static inventory.
- `commands.sh`: Reference command sequence for installing Ansible, creating an SSH key, testing connectivity, and running an ad-hoc command.

## Steps

Install Ansible:

```bash
sudo apt-get update
sudo apt-get install -y ansible
```

Generate an SSH key:

```bash
ssh-keygen -t ed25519 -C "ansible-control" -f ~/.ssh/ansible_key -N ""
```

Copy the public key to the managed node:

```bash
ssh-copy-id -i ~/.ssh/ansible_key.pub user@MANAGED_NODE_IP
```

Update `inventory.ini` with your managed node IP and SSH username.

## Verification

Test connectivity:

```bash
ansible -i inventory.ini managed_nodes -m ping
```

Run an ad-hoc disk-space command:

```bash
ansible -i inventory.ini managed_nodes -m command -a "df -h"
```

Expected result: the ping module returns `pong`, and the disk command prints filesystem usage from the managed node.
