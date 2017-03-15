#!bin/bash
./gradlew bootRepackage
docker build -t movie-theater:latest -t movie-theater:${1} .