#!/bin/bash
set -xe

## Redirecting File handlers
touch /app/log/stdout.log
touch /app/log/stderr.log
ln -sf /proc/$$/fd/1 /app/log/stdout.log
ln -sf /proc/$$/fd/2 /app/log/stderr.log

SCRIPT_HOME=$(dirname "$0")
SSL_LOCATION=$1

echo "TEST_ENABLED: ${TEST_ENABLED}"
PASS_PHRASE=$(date +%s | sha256sum | base64 | head -c 32)
export APP_PASS_PHRASE=${PASS_PHRASE}

echo "JAVA_OPTS: ${JAVA_OPTS}"

## Start Process
# exec into process and take over PID
>/app/log/stdout.log 2>/app/log/stderr.log exec "$@"
