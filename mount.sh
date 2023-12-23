#!/bin/bash

# via volume an error is encountered in entrypoint docker-run.sh on the first build
# volume is already mounted; needs postponed execution
docker cp ./mountable/broker.xml aremis_contatiner:/var/lib/artemis-instance/etc/broker.xml