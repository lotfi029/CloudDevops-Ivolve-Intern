# iVolve Cloud DevOps Accelerator Labs

This repository contains hands-on solutions for the iVolve Cloud DevOps Accelerator program. The labs cover build tools, Docker, Kubernetes, Jenkins CI/CD, ArgoCD GitOps, and Ansible automation.

## Repository Structure

| Module | Folder | Labs | Focus |
|---|---|---:|---|
| Build tools and Docker basics | `docker/` | 1-9 | Gradle, Maven, Docker images, volumes, networks, Compose |
| Kubernetes orchestration | `Kubernetes/` | 10-20 | Taints, namespaces, ConfigMaps, Secrets, storage, StatefulSets, Deployments, NetworkPolicies, DaemonSets, RBAC |
| Jenkins CI/CD | `jenkins/` | 21-23 | Authorization, deployment pipelines, agents, shared libraries |
| ArgoCD GitOps | `argocd/` | 24 | Git-driven Kubernetes deployment with ArgoCD |
| Ansible automation | `ansible/` | 25-29 | Inventories, playbooks, roles, Vault, AWS dynamic inventory |

## Quick Navigation

- [Docker Labs](docker/)
- [Kubernetes Labs](Kubernetes/)
- [Jenkins Labs](jenkins/)
- [ArgoCD Labs](argocd/)
- [Ansible Labs](ansible/)

## Lab Index

### Docker and Build Tools

- [Lab 1: Gradle Java Build](docker/Docker_1/)
- [Lab 2: Maven Java Build](docker/Docker_2/)
- [Lab 3: Single-Stage Spring Boot Docker Image](docker/Docker_3/)
- [Lab 4: Runtime Image with Pre-Built JAR](docker/Docker_4/)
- [Lab 5: Multi-Stage Docker Build](docker/Docker_5/)
- [Lab 6: Docker Environment Variables](docker/Docker_6/)
- [Lab 7: Docker Volumes and Bind Mounts](docker/Docker_7/)
- [Lab 8: Custom Docker Network](docker/Docker_8/)
- [Lab 9: Node.js and MySQL with Docker Compose](docker/Docker_9/)

### Kubernetes

- [Lab 10: Node Taints](Kubernetes/lab-10/)
- [Lab 11: Namespace and ResourceQuota](Kubernetes/lab-11/)
- [Lab 12: ConfigMaps and Secrets](Kubernetes/lab-12/)
- [Lab 13: Persistent Storage](Kubernetes/lab-13/)
- [Lab 14: MySQL StatefulSet](Kubernetes/lab-14/)
- [Lab 15: Node.js Deployment and Service](Kubernetes/lab-15/)
- [Lab 16: Init Container](Kubernetes/lab-16/)
- [Lab 17: Resource Requests and Limits](Kubernetes/lab-17/)
- [Lab 18: NetworkPolicy](Kubernetes/lab-18/)
- [Lab 19: DaemonSet](Kubernetes/lab-19/)
- [Lab 20: RBAC and ServiceAccounts](Kubernetes/lab-20/)

### Jenkins

- [Lab 21: Role-Based Authorization](jenkins/lab-21/)
- [Lab 22: Jenkins Deployment Pipeline](jenkins/lab-22/)
- [Lab 23: Jenkins Agents and Shared Libraries](jenkins/lab-23/)

### ArgoCD

- [Lab 24: GitOps Workflow](argocd/lab-24/)

### Ansible

- [Lab 25: Initial Ansible Configuration](ansible/lab-25/)
- [Lab 26: Nginx Web Server Playbook](ansible/lab-26/)
- [Lab 27: Ansible Roles](ansible/lab-27/)
- [Lab 28: Ansible Vault](ansible/lab-28/)
- [Lab 29: AWS Dynamic Inventory](ansible/lab-29/)

## Common Prerequisites

- Linux shell environment or compatible terminal.
- Docker and Docker Compose.
- Java, Maven, and Gradle for build labs.
- Kubernetes cluster such as Minikube, Kind, or a cloud cluster.
- `kubectl` configured for the target cluster.
- Jenkins LTS for CI/CD labs.
- ArgoCD for GitOps labs.
- Ansible for automation labs.
- AWS CLI and credentials for the dynamic inventory lab.

## Notes

- Replace placeholders such as `YOUR_DOCKERHUB_USERNAME`, `YOUR_USER`, `YOUR_REPO`, `MANAGED_NODE_IP`, and AWS credentials before running commands.
- Some labs depend on earlier resources. For example, Kubernetes app deployments depend on the `ivolve` namespace, secrets, config maps, storage, and MySQL resources from previous labs.
- Screenshots are included in Docker lab folders where available and are referenced from their README files.
- Generated artifacts such as Maven `target/`, Gradle `build/`, and container images may be recreated by running the lab commands.

## Verification

Each lab folder has its own `README.md` with setup steps and validation commands. Start from the module README, then open the specific lab README for the exact workflow.
