package kr.disdong.virtual.drivers.api.client.config.feign

import feign.Logger
import org.springframework.cloud.openfeign.FeignFormatterRegistrar
import org.springframework.context.annotation.Bean
import org.springframework.format.FormatterRegistry
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar

open class DefaultFeignConfig {

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.BASIC
    }

    @Bean
    fun dateTimeFormatterRegistrar(): FeignFormatterRegistrar {
        return FeignFormatterRegistrar { registry: FormatterRegistry ->
            val registrar = DateTimeFormatterRegistrar()
            registrar.setUseIsoFormat(true)
            registrar.registerFormatters(registry)
        }
    }
}
