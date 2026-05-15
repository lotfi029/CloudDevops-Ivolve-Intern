# kubectl Role

This role installs the kubectl client binary.

## Defaults

- `kubectl_version`: defaults to `v1.29.0`.

## Tasks

- Download kubectl to `/usr/local/bin/kubectl`.
- Mark it executable.
- Run `kubectl version --client` for verification.
