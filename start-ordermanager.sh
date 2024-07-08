#!/bin/bash

echo Building ORDERMANAGER
echo
echo gradle build...
gradle build
echo
echo docker compose build...
docker compose build
echo Building completed
echo
echo Running ORDERMANAGER 
docker compose up -d
