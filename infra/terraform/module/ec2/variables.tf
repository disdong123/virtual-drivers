variable "instance_type" {
  default = "t2.micro"
}

variable "ami" {
  default = "ami-0f3a440bbcff3d043"
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

variable "keypair_name" {}

variable "user_data" {}

variable "keypair_filename" {}

variable "sg_name" {}