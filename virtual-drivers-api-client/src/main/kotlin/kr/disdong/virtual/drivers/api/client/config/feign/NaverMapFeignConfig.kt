package kr.disdong.virtual.drivers.api.client.config.feign

import feign.RequestInterceptor
import feign.RequestTemplate
import kr.disdong.virtual.drivers.api.client.config.feign.properties.NaverMapProperties
import org.springframework.context.annotation.Bean

class NaverMapFeignConfig(
    private val naverMapProperties: NaverMapProperties,
) : DefaultFeignConfig() {

    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header("X-NCP-APIGW-API-KEY-ID", naverMapProperties.clientId)
            requestTemplate.header("X-NCP-APIGW-API-KEY", naverMapProperties.clientSecret)
        }
    }
}
