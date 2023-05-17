#!/usr/bin/env bash

set +x

echo "Checking argocd namespace existence"
kubectl get ns argocd > /dev/null 2>&1

if [ $? != 0 ]; then
  echo "argocd namespace does not exist, creating..."
  kubectl create ns argocd > /dev/null 2>&1
fi

## Create a Master Key
# openssl req -new -newkey rsa:4096 -x509 -sha256 -days 365 -nodes -out tls.crt -keyout tls.key

## Sealed Secrets certificates
kubectl create secret generic sealed-secrets-key \
  -n argocd \
  --from-file=../.keys/tls.crt \
  --from-file=../.keys/tls.key

kubectl create secret generic github-deploy-key \
  -n argocd \
  --from-file=../.keys/cf-explorer

#echo "Fetching helm dependencies for main app"
#helm dependency build

echo "Updating helm dependencies for main app"
helm dependency update

helm upgrade --install argocd -n argocd . -f values-secrets.yaml -f values-dev-preprod.yaml

