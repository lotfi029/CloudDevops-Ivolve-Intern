# Lab 21: Role-Based Authorization in Jenkins

This lab configures Jenkins authorization with separate administrator and read-only user roles.

## Goal

Use the Role-based Authorization Strategy plugin to create two access levels:

- `admin`: full Jenkins permissions.
- `viewer`: read-only access to Jenkins, jobs, and views.

## Prerequisites

- Jenkins is installed and running.
- You have an administrator account.
- Jenkins can install plugins from the update center.

## Steps

1. Open Jenkins and go to `Manage Jenkins` > `Plugins`.
2. Install the `Role-based Authorization Strategy` plugin.
3. Go to `Manage Jenkins` > `Security`.
4. Under `Authorization`, choose `Role-Based Strategy`, then save.
5. Go to `Manage Jenkins` > `Manage and Assign Roles` > `Manage Roles`.
6. Create an `admin` role and grant all permissions.
7. Create a `viewer` role and grant only read permissions:
   - `Overall/Read`
   - `Job/Read`
   - `View/Read`
8. Go to `Manage Jenkins` > `Users`.
9. Create two users:
   - `user1` with password `user1pass`
   - `user2` with password `user2pass`
10. Go to `Manage and Assign Roles` > `Assign Roles`.
11. Assign:
   - `user1` to `admin`
   - `user2` to `viewer`

## Verification

- Log in as `user1`: the user should be able to create, configure, and delete jobs.
- Log in as `user2`: the user should only be able to view Jenkins resources and should not be able to create or delete jobs.

## Notes

Use stronger passwords in real environments. The credentials above are lab examples only.
