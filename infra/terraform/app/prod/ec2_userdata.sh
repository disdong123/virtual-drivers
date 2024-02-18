#!/bin/bash
sudo apt-get update -y
sudo apt-get remove docker docker-engine docker.io -y
sudo apt-get install docker.io -y
sudo apt-get install docker-compose -y
sudo service docker start
sudo chown root:docker /var/run/docker.sock
sudo usermod -aG docker ubuntu