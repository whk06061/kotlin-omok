package domain.stone

import domain.stone.BlackStone
import domain.stone.Stones
import domain.stone.WhiteStone
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StonesTest {

    @Test
    fun `가지고 있는 돌 중에 흑돌들만 반환한다`() {
        val stones = Stones(setOf(BlackStone('A', 1), BlackStone('A', 2), WhiteStone('C', 1)))
        assertThat(stones.blackStones).containsExactly(BlackStone('A', 1), BlackStone('A', 2))
    }

    @Test
    fun `가지고 있는 돌 중에 백돌들만 반환한다`() {
        val stones = Stones(setOf(BlackStone('A', 1), BlackStone('A', 2), WhiteStone('C', 1)))
        assertThat(stones.whiteStones).containsExactly(WhiteStone('C', 1))
    }

    @Test
    fun `가지고 있는 돌에 돌을 추가해 새로운 Stones 객체를 반환한다`() {
        val stones = Stones(setOf(BlackStone('A', 1), BlackStone('A', 2), WhiteStone('C', 1)))
        val newStones = stones.addStone(WhiteStone('C', 10))
        assertThat(newStones.stones).containsExactly(
            BlackStone('A', 1),
            BlackStone('A', 2),
            WhiteStone('C', 1),
            WhiteStone('C', 10)
        )
    }
}