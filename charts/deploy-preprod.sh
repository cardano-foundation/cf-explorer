#!/bin/bash

helm upgrade --install -f cf-explorer/values-preprod.yaml -n cf-explorer cf-explorer cf-explorer
