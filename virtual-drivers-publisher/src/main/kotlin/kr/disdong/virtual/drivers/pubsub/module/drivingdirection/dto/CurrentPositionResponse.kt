package kr.disdong.virtual.drivers.pubsub.module.drivingdirection.dto

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position

data class CurrentPositionResponse(
    val directionId: Long,
    val position: Position,
)
