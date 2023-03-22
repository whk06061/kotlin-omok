package domain.state

import domain.stone.BlackStone
import domain.stone.Point
import domain.stone.Stones
import domain.stone.WhiteStone
import domain.stone.XCoordinate
import domain.stone.YCoordinate
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class BlackWinTest {

    @Test
    fun `흑돌이 이긴 상태에서 바둑을 두려고 하면 에러가 발생한다`() {
        val state = BlackWin(Stones(setOf(BlackStone(XCoordinate.of('B'), YCoordinate.of(2)))))
        assertThatIllegalStateException().isThrownBy {
            state.put(Point(XCoordinate.of('A'), YCoordinate.of(1)))
        }.withMessage("게임이 끝나면 돌을 둘 수 없습니다.")
    }

    @Test
    fun `흑돌이 이긴 상태를 생성할 때 흑돌의 개수가 백돌의 개수보다 1개 더 많지 않으면 에러가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            BlackWin(
                Stones(setOf(BlackStone('B', 2), BlackStone('C', 3), WhiteStone('B', 12), WhiteStone('B', 13)))
            )
        }.withMessage("흑돌 승리 상태에서는 흑돌의 개수가 백돌의 개수보다 1개 더 많아야 합니다.")
    }
}
