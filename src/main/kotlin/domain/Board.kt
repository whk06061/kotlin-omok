package domain

import domain.rule.RuleAdapter
import domain.state.BlackTurn
import domain.state.BlackWin
import domain.state.Finished
import domain.state.State

class Board {

    private var state: State = BlackTurn(setOf(), setOf())

    fun put(stone: Stone, blackRuleAdapter: RuleAdapter) {
        state = if (isBlackTurn()) state.put(
            stone,
            blackRuleAdapter
        ) else state.put(stone)
    }

    fun isFinished(): Boolean = state is Finished

    fun isBlackTurn(): Boolean = state is BlackTurn

    fun isBlackWin(): Boolean = state is BlackWin

    fun blackStoneIsPlaced(stone: Stone): Boolean = state.blackStones.contains(stone)

    fun whiteStoneIsPlaced(stone: Stone): Boolean = state.whiteStones.contains(stone)
}
