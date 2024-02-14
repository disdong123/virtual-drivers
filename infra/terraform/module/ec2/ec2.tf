resource "aws_instance" "virtual_drivers_server" {
  ami = var.ami
  instance_type = var.instance_type
  tags = {
    Name = var.name
    name = var.tag_creator
    env = var.tag_env
  }
}