package net.zdendukmonarezio.takuzu.domain.game

import net.zdendukmonarezio.takuzu.domain.game.models.game.Board
import net.zdendukmonarezio.takuzu.domain.game.models.game.GameBoard
import net.zdendukmonarezio.takuzu.domain.game.models.game.IllegalMoveException
import net.zdendukmonarezio.takuzu.domain.common.extensions.set
import net.zdendukmonarezio.takuzu.domain.common.utils.FieldPickerUtil
import net.zdendukmonarezio.takuzu.domain.game.models.hint.Hinter
import net.zdendukmonarezio.takuzu.domain.game.models.hint.models.Hint
import net.zdendukmonarezio.takuzu.domain.game.models.solver.Solver

/**
 * Created by samuelkodytek on 06/03/2017.
 */
class Game private constructor(private val board: Board) : Takuzu {
    val hinter = Hinter(board)

    override fun isBoardFilled(): Boolean {
        return false;
    }

    override fun onMoveMade(x: Int, y: Int): Takuzu {
        if(!isMovePossible(x, y))
            throw IllegalMoveException("Illegal move at position [" + x + ";" + y + "]")

        return createGame(board.set(x, y, FieldPickerUtil.nextField(board.getFields()[x][y])))
    }

    override fun getGameBoard(): Board {
        return board
    }

    override fun isMovePossible(x: Int, y: Int): Boolean {
        return !board.getLockedFields().contains(Pair(x, y))
    }

    override fun isGameOver(): Boolean {
        return board.validateAll()
    }

    override fun getWrongFields(): Hint {
        return hinter.hintNext()
    }

    companion object Game {
        @JvmStatic fun createNew(rows: Int, colums: Int): Takuzu = Game(GameBoard.createBlankBoard(rows, colums))

        private fun createGame(board: Board): Takuzu = Game(board)
    }

}