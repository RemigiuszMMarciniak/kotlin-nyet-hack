import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Szynk Hipolit'a"
const val GOLD_TO_DRAGON_COIN_RATE = 1.43
var playerDragonCoins = 5.0
var playerGold = (playerDragonCoins * GOLD_TO_DRAGON_COIN_RATE).toInt()
var playerSilver = ((playerDragonCoins * GOLD_TO_DRAGON_COIN_RATE) % 1 * 100).roundToInt()
var dragonBreathBarrels = 5.0

//val patronList:List<String> = listOf("Ela","Mordeczka","Zocha")


fun main(args : Array<String>) {

//    println(patronList)
//    println(patronList[0])
//    println(patronList.first())
//    println(patronList.last())
//    println(patronList.getOrElse(4) { "Unknown index"})
//    println()
//
//    val fifthPatron = patronList.getOrNull(4) ?: "Unknown index"
//    println(fifthPatron)
//
//    if(patronList.contains("Ewa")){
//        println("Ewa!")
//    }else{
//        println("no Ewa!")
//    }
//
//    if(patronList.containsAll(listOf("Zocha","Mordeczka"))){
//        println("Zocha and Mordeczka!")
//    }else{
//        println("no Zocha and Mordeczka!")
//    }
//    val mutablePatronList : MutableList<String> = mutableListOf("Pedro","John","Jane")
//    println(mutablePatronList)
//    mutablePatronList.remove("Pedro")
//    mutablePatronList.add("Santiago")
//    mutablePatronList.add(0,"Wayne")
//    println(mutablePatronList)
//
//    val readOnlyPatronList = mutablePatronList.toList()
//    println(readOnlyPatronList)
//
//    mutablePatronList[0] = "Dwayne"
//    println(mutablePatronList)
//

    val patronList:MutableList<String> = listOf("Ela","Mordeczka","Zocha").toMutableList()
    val lastName = listOf<String>("Ironfoot","Cutthroat","Plague")

    val menuList = File("data/tavern-menu-items.txt")
            .readText()
            .split("\n")

    for ( patron in patronList ){
        println("$patron! Hello!")
    }

//    val list = listOf("Ela","Mordeczka","Zocha")
//    list += listOf("John","Jane")
//    list -= "Ela"
//    println(list)
//    list.removeIf {it.contains("o")}
//    println(list)
//    list.clear()
//    println(list)
//
//    var counter = 0
//    for(i in 0..9){
//        println(i)
//        counter += 1
//    }
//    println("counter: $counter")
//
//    patronList.forEach { patron ->
//        println("$patron! Heey!")
//    }


    menuList.forEachIndexed { index, data ->
        println("$index : $data")
    }

    patronList.forEachIndexed { index, patron ->
        println("Hello $patron! You are number ${index+1}.")
        placeOrder(patron,menuList.shuffled().first())
    }

    val (goldMedal, _,bronzeMedal) = patronList
    println("$goldMedal , $bronzeMedal")

    //sets

    val planets = setOf("Mercury", "Venus", "Earth","Earth","Earth","Earth")
    println(planets)
    println(planets.contains("Ziemia"))
    println(planets.containsAll(listOf("Mercury","Earth")))

    println(planets.elementAt(2))

//    println(playerGold)
//    println(playerSilver)
//    placeOrder()
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("shandy,Dragon Breath, 5.91")
//    placeOrder("elixir,Pidgeon, 4.83")

//    val omSymbol = '\u0950'
//    println(omSymbol)
//    println(Integer.toBinaryString(42))
//    println(Integer.toBinaryString(-42))
//    println(42.shl(1))
//    println(42.shr(1))
//    println(42.inv())
//    println(42.xor(33))
//    println(42.or(33))
//    println(42.and(33))


}
private fun placeOrder(patronName:String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(6 until indexOfApostrophe)
    println("$patronName and $tavernMaster talk about the order")
}
private fun placeOrder(patronName:String, menuData : String){
    placeOrder(patronName)

    val (type, name, price) = menuData.split(',')


//    val isEnoughMoney = performPurchase(price.toDouble())
    val isEnoughMoney = true
    if(isEnoughMoney){
        val message = "$patronName has bought $name ($type) for $price"
        println(message)

        val phrase = if(name == "Dragon Breath"){
            "$patronName: ${toDragonSpeak("Wow... this $name is amazing! AAAAAAAAA")}"
        }else{
            "$patronName: thank you for $name"
        }
        println(phrase)
    }else{
        println("$patronName doesn't have enough money")
    }

}
private fun performPurchase(price : Double) : Boolean{
    displayBalance()
    val totalPurse = playerGold + playerSilver/100.0
//    println("Total money: $totalPurse")
    println("Total money: ${"%.4f".format(playerDragonCoins)}")
    println("Ordering a product for $price")
    val remainingBalance = totalPurse - price
    return if(remainingBalance < 0){
        false
    }else {
//        println("Remaining total money: ${"%.2f".format(remainingBalance)}")
        val remainingDragonCoins = remainingBalance / GOLD_TO_DRAGON_COIN_RATE
        println("Remaining total money: ${"%.4f".format(remainingDragonCoins)}")
        playerDragonCoins = remainingDragonCoins
        playerGold = (playerDragonCoins * GOLD_TO_DRAGON_COIN_RATE).toInt()
        playerSilver = ((playerDragonCoins * GOLD_TO_DRAGON_COIN_RATE) % 1 * 100).roundToInt()
        println(playerGold)
        println(playerSilver)

//        val remainingGold = remainingBalance.toInt()
//        val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
//        playerGold = remainingGold
//        playerSilver = remainingSilver
        displayBalance()

        dragonBreathBarrels -= 0.125
        displayDragonBreathStock()
        true
    }
}



private fun displayDragonBreathStock(){
    println("Remaining Dragon Breath barrels: $dragonBreathBarrels")
//    if(( (dragonBreathBarrels - 2.0) % 1.5) == 0.0){
//        val remainingDragonBreathGlasses = ( dragonBreathBarrels / 0.125 ).toInt()
//        println("Remaining Dragon Breath glasses: $remainingDragonBreathGlasses")
//    }
    if( dragonBreathBarrels == 3.5){
        val remainingDragonBreathGlasses = ( dragonBreathBarrels / 0.125 ).toInt()
        println("Remaining Dragon Breath glasses: $remainingDragonBreathGlasses")
    }
}

private fun displayBalance(){
//    println("Player sack: gold $playerGold , silver $playerSilver")
    println("Player sack: dragon coins ${"%.4f".format(playerDragonCoins)}")
}

private fun toDragonSpeak(phrase : String) : String {
    return phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value){
            "A" -> "4"
            "E" -> "3"
            "I" -> "1"
            "O" -> "0"
            "U" -> "|_|"
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
}




