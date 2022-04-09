package net.nathan.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

class DiceRollTest{
    @Test
    fun generates_number(){
        val dice = Dice(6)
        val rollResult = dice.roll()
        assertTrue("the value of rollResult must is between 1 and 6", rollResult in 1..6)
    }

}