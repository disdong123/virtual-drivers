resource "aws_instance" "virtual_drivers_server" {
  ami = var.ami
  instance_type = var.instance_type
  user_data = var.user_data
  vpc_security_group_ids = [aws_security_group.virtual_drivers_server_sg.id]
  key_name = aws_key_pair.virtual_drivers_server_keypair.key_name
  tags = {
    Name = var.name
    name = var.tag_creator
    env = var.tag_env
  }
}

resource "tls_private_key" "virtual_drivers_server_key" {
  algorithm = "RSA"
  rsa_bits = 4096
}

resource "aws_key_pair" "virtual_drivers_server_keypair" {
  key_name   = var.keypair_name
  public_key = tls_private_key.virtual_drivers_server_key.public_key_openssh
}

resource "local_file" "virtual_drivers_server_key_pem" {
  content  = tls_private_key.virtual_drivers_server_key.private_key_pem
  file_permission = "0400"
  filename = var.keypair_filename
}

resource "aws_security_group" "virtual_drivers_server_sg" {
  name = var.sg_name
  ingress {
    description = "Allow HTTP from anywhere"
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    description = "Allow SSH from anywhere"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = var.name
    name = var.tag_creator
    env = var.tag_env
  }
}