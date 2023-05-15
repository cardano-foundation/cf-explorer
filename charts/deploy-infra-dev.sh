#!/bin/bash

cd cf-explorer-infra && helm dependency update && cd ..

helm upgrade --install -f cf-explorer-infra/values-dev.yaml -n cf-explorer cf-explorer-infra cf-explorer-infra
