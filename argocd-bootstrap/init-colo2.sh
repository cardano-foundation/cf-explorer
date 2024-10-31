#!/usr/bin/env bash

set +x

STAGE=${STAGE:-uat}
NETWORK=${NETWORK:-mainnet}

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

## DockerHub secret
export DOCKER_USER=$DOCKER_USER
export DOCKER_PASSWORD=$DOCKER_PASSWORD
export DOCKER_REGISTRY_SERVER=docker.io

kubectl get secret -n cf-explorer regcred || \
  kubectl create secret -n cf-explorer docker-registry regcred \
    --docker-server=$DOCKER_REGISTRY_SERVER \
    --docker-username=$DOCKER_USER \
    --docker-password=$DOCKER_PASSWORD

echo "Updating helm dependencies for main app"
helm dependency update

export ARGOCD_PASSWORD=${ARGOCD_PASSWORD:-CH4NG3@M3}
export ARGOCD_HASHED_PASSWORD=$(htpasswd -nbBC 10 null $ARGOCD_PASSWORD | sed 's|null:\(.*\)|\1|g')

kubectl kustomize https://github.com/argoproj/argo-cd.git/manifests/crds?ref=master | kubectl apply -n argocd -f -
helm upgrade --install argocd -n argocd . \
  --set "argo-cd.configs.secret.argocdServerAdminPassword=${ARGOCD_HASHED_PASSWORD}" \
  --set "argo-cd.configs.secret.argocdServerAdminPasswordMtime=$(date +%FT%T%Z)" \
  --set valueFile=values-${STAGE}-${NETWORK}.yaml
