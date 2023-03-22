package domain

import domain.rule.RuleAdapter
import domain.state.BlackTurn
import domain.state.BlackWin
import domain.state.Finished
import domain.state.State
import domain.state.WhiteTurn
import domain.stone.Point
import domain.stone.Stone
import domain.stone.Stones
import java.lang.IllegalArgumentException

class Board {

    private var state: State = BlackTurn(Stones(setOf()))
    private val defaultRuleAdapter = RuleAdapter(listOf())

    fun put(point: Point, blackRuleAdapter: RuleAdapter = defaultRuleAdapter) {
        state = when {
            isBlackTurn() -> state.put(point, blackRuleAdapter)
            isWhiteTurn() -> state.put(point)
            else -> throw IllegalArgumentException("둘을 둘 수 없는 상태입니다.")
        }
    }

    fun isFinished(): Boolean = state is Finished

    fun isBlackTurn(): Boolean = state is BlackTurn
    fun isWhiteTurn(): Boolean = state is WhiteTurn

    fun isBlackWin(): Boolean = state is BlackWin

    fun blackStoneIsPlaced(stone: Stone): Boolean = state.stones.blackStones.contains(stone)

    fun whiteStoneIsPlaced(stone: Stone): Boolean = state.stones.whiteStones.contains(stone)
}
