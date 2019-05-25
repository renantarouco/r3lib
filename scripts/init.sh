#!/bin/sh
git submodule update --init --recursive --remote
. scripts/compile-ant-libs.sh
. scripts/deploy-ant-libs.sh
mvn package