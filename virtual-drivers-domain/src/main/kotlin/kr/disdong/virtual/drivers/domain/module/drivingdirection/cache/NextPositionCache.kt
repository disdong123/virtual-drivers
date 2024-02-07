package kr.disdong.virtual.drivers.domain.module.drivingdirection.cache

interface NextPositionCache {

    fun get(): List<NextPositionFinder>
    fun add(value: NextPositionFinder)
    fun put(values: List<NextPositionFinder>)
}

data class NextPositionFinder(
    val routeOrder: Int = 1,
    val index: Int = 0,
)
