# Cluster Bootstrapping

This module is responsible for bootstrapping Kubernetes cluster for the Explorer projects.

Clusters can be bootstrapped using the [init.sh](init.sh) script. Please check next paragraph to learn about the 
init script requirements

## Requirements

The init script will deploy both [ArgoCD](https://argo-cd.readthedocs.io/en/stable/) and the [Main App](https://argo-cd.readthedocs.io/en/stable/operator-manual/cluster-bootstrapping/).
Once installed, ArgoCD will observe the patterns of the GitOps approach and ensure that the kubernetes cluster deployment(s) are in sync
with the definition contained in the relevant git projects.

In order for ArgoCD to access GitHub, a number of _secrets_ need to be created.
1. Deployment keys for all the GitHub projects involved
2. [Sealed Secret](https://github.com/bitnami-labs/sealed-secrets) main key required to decrypt deployment keys at the point above

## Sealed Secret

Kubernetes `Secrets` are not encrypted, but rather just base64 encoded. So it is recommended to **NOT** version control them.

[Sealed Secrets](https://github.com/bitnami-labs/sealed-secrets) is the simplest solution for safely dealing with secrets and allow
developer to version control them.

From their own documentation:

> Problem: "I can manage all my K8s config in git, except Secrets."

> Solution: Encrypt your Secret into a SealedSecret, which is safe to store - even inside a public repository. 
> The SealedSecret can be decrypted only by the controller running in the target cluster and nobody else (not even the original author) 
> is able to obtain the original Secret from the SealedSecret.

