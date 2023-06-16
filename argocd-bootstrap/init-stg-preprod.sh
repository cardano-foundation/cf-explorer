#!/usr/bin/env bash

set +x

echo "Checking argocd namespace existence"
kubectl get ns argocd > /dev/null 2>&1

if [ $? != 0 ]; then
  echo "argocd namespace does not exist, creating..."
  kubectl create ns argocd > /dev/null 2>&1
fi

echo "Checking cf-explorer namespace existence"
kubectl get ns cf-explorer > /dev/null 2>&1

if [ $? != 0 ]; then
  echo "cf-explorer namespace does not exist, creating..."
  kubectl create ns cf-explorer > /dev/null 2>&1
fi

## Create a Master Key
# openssl req -new -newkey rsa:4096 -x509 -sha256 -days 365 -nodes -out tls.crt -keyout tls.key

## DockerHub secret
kubectl create secret -n cf-explorer generic regcred \
  --from-file=.dockerconfigjson=../.keys/docker-cred.json \
  --type=kubernetes.io/dockerconfigjson \
  --save-config \
  --dry-run=client \
  -o yaml \
  | kubectl apply -f -

## Sealed Secrets certificates
#kubectl create secret generic sealed-secrets-key \
#  --save-config \
#  --dry-run=client \
#  -o yaml \
#  -n argocd \
#  --from-file=../.keys/tls.crt \
#  --from-file=../.keys/tls.key \
#  | kubectl apply -f -

# Git Hub deploy key
#kubectl create secret generic github-deploy-key \
#  --save-config \
#  --dry-run=client \
#  -o yaml \
#  -n argocd \
#  --from-file=../.keys/cf-explorer \
#  | kubectl apply -f -

# Infra Secrets (eg Psql, Redis, etc.)
kubectl create secret generic infra-other-secrets \
  --save-config \
  --dry-run=client \
  -o yaml \
  -n cf-explorer \
  --from-env-file=../.keys/infra-secrets-dev-mainnet \
  | kubectl apply -f -

#echo "Fetching helm dependencies for main app"
#helm dependency build

echo "Updating helm dependencies for main app"
helm dependency update

helm upgrade --install argocd -n argocd . \
  --set git.targetRevision=feat/Add_Stg_Preprod \
  --set valueFile=values-stg-preprod.yaml \
  -f values-secrets.yaml
