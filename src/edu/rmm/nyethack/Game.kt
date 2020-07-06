package edu.rmm.nyethack

import java.lang.IllegalArgumentException

const val MAX_EXPERIENCE : Int = 5000
const val MAX_MAGICAL_INTOXICATION :Int = 50
fun main (args : Array<String>){
    Game.play()
}

fun printIsSourceOfBlessings(any:Any){
    val isSourceOfBlessings = if(any is Player){
        any.isBlessed
    }else{
        (any as Room).name == "Blessing Fountain"
    }
    println("$any is a source of blessings: $isSourceOfBlessings")
}



private fun performCombat(){
    println("No reason to start combat")
}
private fun performCombat(enemyName:String){
    println("fighting with $enemyName")
}
private fun performCombat(enemyName: String, isBlessed: Boolean){
    if(isBlessed){
        println("fighting with $enemyName + with 2 x damage")
    }else{
        println("fighting with $enemyName")
    }
}

object Game{
    private val player = Player("Mordowycz")
    private var currentRoom : Room = TownSquare()
    init {
        println("Welcome adventurer!")
        player.castFireball()
    }
    fun play(){
        while(true){
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            println("> Enter command: ")
//            println("Command: ${readLine()}")
            println(GameInput(readLine()).processCommand())

//            println(PremadeWorldMap.load())
//            val abandonedTownSquare = object : TownSquare(){
//                override fun load() = "Nothing here... void..."
//            }
//            println(abandonedTownSquare.load())

            val (x,y) = Coordinate(5,5)
            val (experience,level) = PlayerScore(1250,5)
        }
    }

    private fun printPlayerStatus(player : Player) {
        println(
                "(Aura: ${player.auraColor()})" +
                        "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg:String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) {""}

        private fun commandNotFound() = "I don't know what to do - wrong command!"
        fun processCommand() = when(command.toLowerCase()){
            else -> commandNotFound()
        }
    }
}