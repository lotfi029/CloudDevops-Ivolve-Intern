# Vault Variables

This folder is used for Ansible Vault secret files in Lab 28.

## Files

- `mysql_secrets.example.yaml`: Plain-text example variable file.
- `mysql_secrets.yaml`: Encrypted vault file you create locally with `ansible-vault create`.

## Create the Encrypted File

```bash
ansible-vault create mysql_secrets.yaml
```

Add the variables shown in `mysql_secrets.example.yaml`.
