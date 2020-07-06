package edu.rmm.nyethack

class PlayerScore(private val experience:Int, private val level:Int) {
    operator fun component1() = experience
    operator fun component2() = level

}
