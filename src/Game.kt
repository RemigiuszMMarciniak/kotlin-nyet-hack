fun main (args : Array<String>){
    val name = "Mordowycz"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false




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
//    aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val karma = (Math.pow(Math.random(),(110 - healthPoints) /100.0) * 20).toInt()
    val auraColor = when(karma){
        in 0..4 -> "RED"
        in 5..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        in 16..20 -> "GREENY"
        else -> "BLACK"
    }
//    val auraColor = if(auraVisible) "GREENY AURA" else "NO AURA"
//    println(auraColor)

//    health status
    println("(Aura: $auraColor)" +
            "(Blessed: ${if(isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")

//    wrong! - this code does not work correctly - formatting strings in kotlin
    val statusFormat = "(HP)(A) -> H"
    var info = ""
    if (statusFormat.contains('H')){
        info += " (H: $healthStatus)"
    }else if(statusFormat.contains('A')){
        info += " (A: $auraColor)"
    }else if(statusFormat.contains('B')){
        info += " (B: $isBlessed)"
    }else{
        info += " (HP: $healthPoints)"
    }
    println(info)
}