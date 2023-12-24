#!/bin/bash

# via volume an error is encountered in entrypoint docker-run.sh on the first build >>> volume is already mounted
docker cp ./mountable/broker.xml artemis_container:/var/lib/artemis-instance/etc/broker.xml