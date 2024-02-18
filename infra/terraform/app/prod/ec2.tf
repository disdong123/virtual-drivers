module "ec2" {
  source = "../../module/ec2"
  keypair_name = "virtual_drivers_server_keypair"
  keypair_filename = "virtual_drivers_server_keypair.pem"
  user_data = file("ec2_userdata.sh")
  sg_name = "virtual_drivers_server_sg"
}