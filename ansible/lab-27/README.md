# Lab 27: Structured Configuration Management with Ansible Roles

This lab organizes infrastructure automation into Ansible roles for Docker, kubectl, and Jenkins.

## Repository Contents

- `inventory.ini`: Example managed-node inventory.
- `site.yaml`: Master playbook that applies all roles.
- `roles/docker/tasks/main.yml`: Installs and enables Docker CE.
- `roles/kubectl/defaults/main.yml`: Defines `kubectl_version`.
- `roles/kubectl/tasks/main.yml`: Downloads and verifies kubectl.
- `roles/jenkins/tasks/main.yml`: Installs Java 21 and Jenkins.

## Role Summary

- `docker`: adds Docker repository, installs Docker CE, and enables the service.
- `kubectl`: downloads the selected kubectl binary to `/usr/local/bin/kubectl`.
- `jenkins`: adds the Jenkins repository, installs Jenkins, and enables the service.

## Run

Update `inventory.ini`, then execute:

```bash
ansible-playbook -i inventory.ini site.yaml
```

## Verification

```bash
ansible -i inventory.ini managed_nodes -m command -a "docker --version"
ansible -i inventory.ini managed_nodes -m command -a "kubectl version --client"
ansible -i inventory.ini managed_nodes -m command -a "jenkins --version"
```

## Notes

The roles target Ubuntu/Debian-style systems that use `apt`.
