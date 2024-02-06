package kr.disdong.virtual.drivers.cache.config

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.cache.concurrent.ConcurrentMapCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
@EnableCaching
class CacheConfig {

    @Bean
    fun cacheManager(): CacheManager {
        return ConcurrentMapCacheManager("virtual-drivers-default-cache")
    }

    @Primary
    @Bean
    fun caffeineCacheManager(): CacheManager {
        return CaffeineCacheManager("virtual-drivers-caffeine-cache")
    }
}
