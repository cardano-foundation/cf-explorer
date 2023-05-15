#!/bin/bash

cd cf-explorer-infra && helm dependency update && cd ..

helm upgrade --install -n cf-explorer cf-explorer-infra cf-explorer-infra
