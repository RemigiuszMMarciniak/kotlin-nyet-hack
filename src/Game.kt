fun main (args : Array<String>){
    val name = "Mordowycz"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false


//    aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if(auraVisible) "GREENY AURA" else "NO AURA"
//    println(auraColor)

//    health
    val healthStatus = when(healthPoints){
        100 -> "is of great health!"
        in 90..99 -> "has some scrapes"
        in 75..89 -> if(isBlessed){
            "has several minor wounds but recovers quickly!"
        }else{
            "has several minor wounds"
        }
        in 15..74 -> "has serious wounds"
        else -> "is in bad condition"
    }
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
    println("(Aura: $auraColor)" +
            "(Blessed: ${if(isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}