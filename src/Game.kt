const val MAX_EXPERIENCE : Int = 5000
const val MAX_MAGICAL_INTOXICATION :Int = 50
fun main (args : Array<String>){
    val name = "Mordowycz"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    //fireball
    val magicalIntoxication = castFireball(5)
    printIntoxication(magicalIntoxication)
    printIntoxication(castFireball(10))
    performCombat()
    performCombat("John")
    performCombat("John",true)

//    aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    //    println(auraColor)

//    health
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    //    val healthStatus = if (healthPoints == 100) "is of great health!"
//    else if(healthPoints in 90..99) "has some scrapes"
//    else if(healthPoints in 75..89)
//        if (isBlessed) "has several minor wounds but recovers quickly!"
//        else "has several minor wounds"
//    else if(healthPoints in 15..74) "has serious wounds"
//    else "is in bad condition!"

//    health status
//    println("$name $healthStatus")

//    quier
    var arrowsInQuier = 2
    if (arrowsInQuier >= 5){
        println("There is a lot of arrows")
        println("Can't take more arrows")
    }
//    health summary
//    val healthSummary = if(healthPoints != 100) "You need healing" else "It is good"

    val race = "gnome"
    val faction = when(race){
        "dwarf" -> "Lords of Underground"
        "gnome" -> "Lords of Underground"
        "orc" -> "Free people from Wavy Hills"
        "human" -> "Free people from Wavy Hills"
        else -> "Outlaws"
    }

    println("$name is a $race and belongs to $faction")

//    health status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor)" +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREENY AURA" else "NO AURA"
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
        100 -> "is of great health!"
        in 90..99 -> "has some scrapes"
        in 75..89 -> if (isBlessed) {
            "has several minor wounds but recovers quickly!"
        } else {
            "has several minor wounds"
        }
        in 15..74 -> "has serious wounds"
        else -> "is in bad condition"
    }
    return healthStatus
}

private fun castFireball(numFireballs:Int = 2) : Int{
    println("Fireball! x $numFireballs")
    return (1 + (MAX_MAGICAL_INTOXICATION-1) * Math.random()).toInt()
}

private fun printIntoxication(intoxication:Int) = when(intoxication){
    in 1..10 -> println("1st grade")
    in 11..20 -> println("2nd grade")
    in 21..30 -> println("3rd grade")
    in 31..40 -> println("4th grade")
    in 41..50 -> println("unconscious")
    else -> println("undefined")

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

private fun `ddasdas` () = println("test")
private fun `dsadsadsadsałłlż`() = println("test")