# Lab 28: Securing Sensitive Data with Ansible Vault

This lab uses Ansible Vault to store MySQL credentials securely while provisioning MySQL and an application database user.

## Repository Contents

- `inventory.ini`: Example managed-node inventory.
- `mysql-playbook.yaml`: Installs MySQL and creates the database/user.
- `vault/mysql_secrets.example.yaml`: Plain-text example of the variables that should be encrypted.

## Create Vault File

Create an encrypted vault file:

```bash
ansible-vault create vault/mysql_secrets.yaml
```

Add:

```yaml
db_password: "S3cur3P@ssword!"
db_root_password: "R00tP@ss!"
```

Do not commit the real `vault/mysql_secrets.yaml` file if it contains real secrets unless your workflow explicitly allows encrypted vault files in Git.

## Run

```bash
ansible-playbook -i inventory.ini mysql-playbook.yaml --ask-vault-pass
```

## Verification

```bash
ansible -i inventory.ini managed_nodes -m command -a "mysql -u ivolve_user -pS3cur3P@ssword! -e 'SHOW DATABASES;'"
```

Expected result: the output includes the `iVolve` database.
