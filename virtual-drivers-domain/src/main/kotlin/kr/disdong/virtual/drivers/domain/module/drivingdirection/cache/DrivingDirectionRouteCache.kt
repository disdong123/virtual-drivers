package kr.disdong.virtual.drivers.domain.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position

interface DrivingDirectionRouteCache {

    fun get(startPosition: Position, endPosition: Position): List<Position>
    fun put(startPosition: Position, endPosition: Position, value: List<Position>)
}
