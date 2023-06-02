@echo off

REM Set your Docker image name and tag
set IMAGE_NAME=ssmitshoek/crm_demo
set IMAGE_TAG=dev

REM Build the Docker image
docker build -t %IMAGE_NAME%:%IMAGE_TAG% .

REM Push the Docker image
echo Pushing Docker image to Docker Hub...
docker push %IMAGE_NAME%:%IMAGE_TAG%

echo Done.
