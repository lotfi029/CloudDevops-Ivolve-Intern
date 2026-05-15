# Lab 29: Automated Host Discovery with Ansible Dynamic Inventory

This lab uses the AWS EC2 dynamic inventory plugin to discover running instances tagged `service=db`, then applies MySQL automation to those hosts.

## Repository Contents

- `aws_inventory.yaml`: Dynamic inventory configuration for AWS EC2.
- `mysql-playbook.yaml`: MySQL provisioning playbook that targets the dynamic `tag_db` group.

## Prerequisites

Install AWS dependencies:

```bash
pip3 install boto3 botocore
ansible-galaxy collection install amazon.aws
```

Configure AWS credentials:

```bash
export AWS_ACCESS_KEY_ID=YOUR_KEY
export AWS_SECRET_ACCESS_KEY=YOUR_SECRET
export AWS_DEFAULT_REGION=us-east-1
```

## Create Example EC2 Instance

```bash
aws ec2 run-instances \
  --image-id ami-0c55b159cbfafe1f0 \
  --instance-type t2.micro \
  --tag-specifications 'ResourceType=instance,Tags=[{Key=service,Value=db}]' \
  --key-name YOUR_KEY_PAIR
```

## List Discovered Hosts

```bash
ansible-inventory -i aws_inventory.yaml --list
```

## Run Playbook

```bash
ansible-playbook -i aws_inventory.yaml mysql-playbook.yaml \
  --ask-vault-pass \
  --private-key ~/.ssh/YOUR_KEY.pem \
  -u ubuntu
```

## Notes

The inventory creates groups from EC2 tags. Instances tagged `service=db` are available through the group name `tag_db`.
