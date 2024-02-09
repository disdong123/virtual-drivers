package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.helper

import kr.disdong.virtual.drivers.broadcast.module.drivingdirection.fixture.drivingdirection.DrivingDirectionFixture
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfoCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionRouteEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.impl.DrivingDirectionRouteImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class CurrentPositionFinderTest {
    private val positionInfoCache = mock<PositionInfoCache>()
    private val drivingDirectionRepository = mock<DrivingDirectionRepository>()
    private val sut = CurrentPositionFinder(
        positionInfoCache = positionInfoCache,
        drivingDirectionRepository = drivingDirectionRepository
    )

    @BeforeEach
    fun setup() {
        doNothing().`when`(positionInfoCache).put(any())
    }

    @Test
    fun `캐싱되어 있는 현재 위치 정보를 이용하여 현재 위치를 가져오고 다음 위치를 캐싱한다`() {
        // given
        val positionInfos = listOf(
            `위치 정보`(order = 0, index = 0, directionId = 1),
            `위치 정보`(order = 1, index = 10, directionId = 2),
            `위치 정보`(order = 2, index = 999, directionId = 3),
        )
        val routes = listOf(
            `라우트 정보`(directionId = 1, routeOrder = 0, subRoutes = List(1) { Position(0.0, 0.0) }),
            `라우트 정보`(directionId = 2, routeOrder = 1, subRoutes = MutableList(11) { Position(0.0, 0.0) }.also { it[10] = Position(1.0, 1.0) }),
            `라우트 정보`(directionId = 3, routeOrder = 2, subRoutes = MutableList(1000) { Position(0.0, 0.0) }.also { it[999] = Position(1.0, 1.0) }),
        )
        val directions = listOf(
            `길찾기 정보`(directionId = 1),
            `길찾기 정보`(directionId = 2),
            `길찾기 정보`(directionId = 3),
        )
        whenever(positionInfoCache.get()).thenReturn(positionInfos)
        whenever(drivingDirectionRepository.findCurrentRoutes(any())).thenReturn(routes)
        whenever(drivingDirectionRepository.findAllByIds(any())).thenReturn(directions)

        // when
        val response = sut.findAll()

        // then
        assertEquals(3, response.size)
        assertEquals(response[0].position, Position(0.0, 0.0))
        assertEquals(response[1].position, Position(1.0, 1.0))
        assertEquals(response[2].position, Position(1.0, 1.0))
        verify(positionInfoCache, times(1)).put(any())
    }

    private fun `위치 정보`(directionId: Long, order: Int, index: Int) = PositionInfo(
        directionId = directionId,
        routeOrder = order,
        index = index,
        endPosition = Position(0.0, 0.0)
    )

    private fun `라우트 정보`(directionId: Long, routeOrder: Int, subRoutes: List<Position>) = DrivingDirectionRouteImpl(
        DrivingDirectionRouteEntity(
            id = 1,
            directionId = directionId,
            routeOrder = routeOrder,
            subRoutes = subRoutes,
        )
    )

    private fun `길찾기 정보`(directionId: Long) = DrivingDirectionFixture.any(directionId)
}
