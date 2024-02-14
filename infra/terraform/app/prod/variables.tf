terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">= 5.4.0"
    }
  }

  required_version = ">= 1.3"
}

variable "domain" {
  default = "bbpstudio.kr"
}

variable "region" {
  default = "ap-northeast-2"
}

variable "iam_user_name" {
  default = "virtual-drivers"
}

variable "iam_policy_arn_list" {
  default = [
    "arn:aws:iam::aws:policy/AmazonEC2FullAccess",
  ]
}