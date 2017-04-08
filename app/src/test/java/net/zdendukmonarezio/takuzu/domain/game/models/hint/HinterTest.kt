package net.zdendukmonarezio.takuzu.domain.game.models.hint

import net.zdendukmonarezio.takuzu.domain.game.models.game.Field
import net.zdendukmonarezio.takuzu.domain.game.models.game.GameBoard
import org.junit.Assert
import org.junit.Test

/**
 * Created by monarezio on 08/04/2017.
 */
class HinterTest {

    @Test
    fun hintRows() {
        val hint = Hinter(GameBoard.createBoard(listOf(
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.ANON),
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.ANON, Field.ANON)
        ), listOf()))
        Assert.assertEquals(Pair(0, 2), hint.hintRows())
    }

    @Test
    fun hintColumns() {
        val hint = Hinter(GameBoard.createBoard(listOf(
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.ANON),
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.BLUE, Field.ANON)
        ), listOf()))
        Assert.assertEquals(Pair(0, 1), hint.hintColumns())
        val hint2 = Hinter(GameBoard.createBoard(listOf(
                listOf(Field.BLUE, Field.BLUE, Field.BLUE, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.BLUE, Field.ANON),
                listOf(Field.BLUE, Field.BLUE, Field.BLUE, Field.RED),
                listOf(Field.BLUE, Field.RED, Field.BLUE, Field.ANON)
        ), listOf()))
        Assert.assertEquals(Pair(0, 2), hint2.hintColumns())
    }

    @Test
    fun hintWrongRow() {
        val hint = Hinter(GameBoard.createBoard(listOf(
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.ANON),
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.BLUE, Field.ANON)
        ), listOf()))
        Assert.assertEquals(1, hint.hintWrongRow())
    }

    @Test
    fun hintWrongColumn() {
        val hint = Hinter(GameBoard.createBoard(listOf(
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.ANON),
                listOf(Field.BLUE, Field.BLUE, Field.RED, Field.RED),
                listOf(Field.BLUE, Field.BLUE, Field.BLUE, Field.ANON)
        ), listOf()))
        Assert.assertEquals(0, hint.hintWrongColumn())
    }

    @Test
    fun hintNext() {

    }

}