package edu.rmm.nyethack

const val MAX_EXPERIENCE : Int = 5000
const val MAX_MAGICAL_INTOXICATION :Int = 50
fun main (args : Array<String>){
    val player = Player("Mordowycz",89,true,false)
    println(player.healthPoints)
    val player2 = Player("Mordowycz")
    println(player2.healthPoints)
    val player3 = Player("Mordowycz",isBlessed = true,isImmortal = false)
    println(player3.healthPoints)
    val player4 = Player("jan")
    println(player4.healthPoints)
//    val player5 = Player("jan",-646,isBlessed = true,isImmortal = false)
//    println(player5)

    player.castFireball()
    player.castFireball(11)


    performCombat()
    performCombat("John")
    performCombat("John", true)

    val auraColor = player.auraColor()

    val healthStatus = player.formatHealthStatus()

    val race = "gnome"
    val faction = when(race){
        "dwarf" -> "Lords of Underground"
        "gnome" -> "Lords of Underground"
        "orc" -> "Free people from Wavy Hills"
        "human" -> "Free people from Wavy Hills"
        else -> "Outlaws"
    }

    println("${player.name} is a $race and belongs to $faction")

//    health status
    printPlayerStatus(player)

    val myD6 = Dice()
    println(myD6.rolledValue)
    println(myD6.rolledValue)
    println(myD6.rolledValue)
}

private fun printPlayerStatus(player : Player) {
    println(
        "(Aura: ${player.auraColor()})" +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
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
