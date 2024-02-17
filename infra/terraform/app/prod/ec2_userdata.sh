#!/bin/bash
sudo apt-get update -y
sudo apt-get remove docker docker-engine docker.io -y
sudo apt-get install docker.io -y
sudo apt-get install docker-compose -y
sudo service docker start
sudo chmod 666 /var/run/docker.sock
sudo usermod -aG docker ubuntu