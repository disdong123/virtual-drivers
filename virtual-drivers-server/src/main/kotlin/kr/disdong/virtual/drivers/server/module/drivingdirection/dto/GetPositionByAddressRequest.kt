package kr.disdong.virtual.drivers.server.module.drivingdirection.dto

data class GetPositionByAddressRequest(
    val address: String,
    val translationType: AddressTranslationType,
)

enum class AddressTranslationType {
    POSITION,
    JIBUN,
}
