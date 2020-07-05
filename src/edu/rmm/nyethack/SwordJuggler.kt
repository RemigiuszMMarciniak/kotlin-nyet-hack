package edu.rmm.nyethack

import java.lang.IllegalStateException

fun main() {
    var swordsJuggling : Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    println(isJugglingProficient)
    if(isJugglingProficient){
        swordsJuggling = 2
    }
    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    }catch (e : Exception){
        println(e)
    }

    println("Number of swords to juggle: $swordsJuggling")
}
private fun proficiencyCheck(swordJuggling : Int?){
//    swordJuggling ?: throw IllegalStateException("Your character is not able to juggle swords!")
//    swordJuggling ?: throw edu.rmm.nyethack.UnskilledSwordJugglerException()
    checkNotNull(swordJuggling,{ "Your character is not able to juggle swords!" })
}
class UnskilledSwordJugglerException() : IllegalStateException("Your character is not able to juggle swords!")
private fun juggleSwords(swordsJugglinng : Int){
    require(swordsJugglinng >= 3, { "You need to juggle at least 3 swords in order to make a fascinating show"})
}