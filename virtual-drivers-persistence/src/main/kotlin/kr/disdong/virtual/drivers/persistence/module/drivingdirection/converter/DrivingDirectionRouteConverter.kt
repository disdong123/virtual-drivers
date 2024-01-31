package kr.disdong.virtual.drivers.persistence.module.drivingdirection.converter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position

@Suppress("UNCHECKED_CAST")
@Converter
class DrivingDirectionRouteConverter(
    private val objectMapper: ObjectMapper,
) : AttributeConverter<List<Position>, String> {
    override fun convertToDatabaseColumn(attribute: List<Position>): String? {
        return objectMapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(s: String?): List<Position> {
        return objectMapper.readValue(s, List::class.java) as List<Position>
    }
}
