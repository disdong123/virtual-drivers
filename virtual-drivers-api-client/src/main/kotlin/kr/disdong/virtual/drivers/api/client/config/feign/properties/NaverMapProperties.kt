package kr.disdong.virtual.drivers.api.client.config.feign.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "naver.map")
data class NaverMapProperties(
    val clientId: String,
    val clientSecret: String
)
