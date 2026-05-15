#!/usr/bin/env bash
set -euo pipefail

sudo apt-get update
sudo apt-get install -y ansible

ssh-keygen -t ed25519 -C "ansible-control" -f ~/.ssh/ansible_key -N ""
ssh-copy-id -i ~/.ssh/ansible_key.pub user@MANAGED_NODE_IP

ansible -i inventory.ini managed_nodes -m ping
ansible -i inventory.ini managed_nodes -m command -a "df -h"
