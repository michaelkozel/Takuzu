package net.zdendukmonarezio.takuzu.domain

import net.zdendukmonarezio.takuzu.domain.models.Board
import net.zdendukmonarezio.takuzu.domain.models.Field
import net.zdendukmonarezio.takuzu.domain.models.GameBoard

/**
 * Created by samuelkodytek on 06/03/2017.
 */
interface Takuzu {

    /**
     * performs when a move was made
     */
    fun onMoveMade(x: Int, y: Int): Takuzu //TODO: discuss

    /**
     * returns gameboard
     */
    fun getGameBoard(): Board //TODO: discuss

    /**
     * checks if move is possible
     */
    fun isMovePossible(x: Int, y: Int): Boolean

    /**
     * check if game is over
     */
    fun isGameOver(): Boolean

    /**
     * returns the coordinates of incorrect fields
     */
    fun getWrongFields(): List<Pair<Int, Int>>
}