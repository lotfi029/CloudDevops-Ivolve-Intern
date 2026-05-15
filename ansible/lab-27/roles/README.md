# Ansible Roles

This folder contains the roles used by Lab 27.

## Roles

- `docker`: Installs Docker CE.
- `kubectl`: Installs kubectl.
- `jenkins`: Installs Jenkins and Java 21.

The master playbook `../site.yaml` applies these roles to the `managed_nodes` inventory group.
