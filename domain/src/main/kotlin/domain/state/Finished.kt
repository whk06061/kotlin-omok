package domain.state

import domain.stone.Stones
import domain.rule.Referee
import domain.stone.Point

abstract class Finished(stones: Stones) : State {

    init {
        require(stones.blackStones.intersect(stones.whiteStones).isEmpty()) { BLACK_WHITE_INTERSECT_ERROR }
    }

    override fun put(point: Point, referee: Referee): State {
        throw IllegalStateException(WHEN_FINISHED_PUT_ERROR)
    }

    companion object {
        private const val WHEN_FINISHED_PUT_ERROR = "게임이 끝나면 돌을 둘 수 없습니다."
        private const val BLACK_WHITE_INTERSECT_ERROR = "흑돌과 백돌이 겹칠 수 없습니다."
    }
}
