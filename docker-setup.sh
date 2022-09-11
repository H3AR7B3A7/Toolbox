#!/bin/bash
echo --- SETTING UP DOCKER CONTAINERS ---
docker-compose -f docker-compose.yml up -d
echo --- DONE! ---
exec "$SHELL"