variable "instance_type" {
  default = "t2.micro"
}

variable "ami" {
  default = "ami-07eff2bc4837a9e01"
}

variable "name" {
  default = "virtual_drivers_server"
}

variable "tag_creator" {
  default = "disdong"
}

variable "tag_env" {
  default = "prod"
}