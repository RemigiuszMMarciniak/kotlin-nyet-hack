import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Szynk Hipolit'a"
const val GOLD_TO_DRAGON_COIN_RATE = 1.43
var playerDragonCoins = 5.0
var playerGold = (playerDragonCoins * GOLD_TO_DRAGON_COIN_RATE).toInt()
var playerSilver = ((playerDragonCoins * GOLD_TO_DRAGON_COIN_RATE) % 1 * 100).roundToInt()
var dragonBreathBarrels = 5.0

val patronList:MutableList<String> = listOf("Ela","Mordeczka","Zocha").toMutableList()
val lastName = listOf<String>("Ironfoot","Cutthroat","Plague")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
        .readText()
        .split("\n")

fun main(args : Array<String>) {

//     menuList.forEachIndexed { index, data ->
//        println("$index : $data")
//    }
//
//    patronList.forEachIndexed { index, patron ->
//        println("Hello $patron! You are number ${index+1}.")
//        placeOrder(patron,menuList.shuffled().first())
//    }

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        println(name)
        uniquePatrons+=name
    }
    println(uniquePatrons)
//
//    println(mutableSetOf(1,2).add(3))
//    println(mutableSetOf(1,2).addAll(listOf(1,2,3,4,5)))

    var orderCount = 0
    while(orderCount <= 9){
        placeOrder(uniquePatrons.shuffled().first(),menuList.shuffled().first())
        orderCount++
    }


//    var isTavernOpen = true
//    val isClosingTime = false
//
//    while(isTavernOpen == true){
//        if (isClosingTime){
//            break
//        }
//        println("party!!!")
//    }

    val tempList = listOf("Ela Urwileb","Ela Urwileb", "Ela Zaraza")
    println(tempList.toSet())
    val setTempList = tempList.toSet()
    println(setTempList.toList()[0])
    println(tempList.toSet().toList())
    println(tempList.distinct())

    val playerAges : IntArray = intArrayOf(32,27,14,52,101)
    playerAges.forEach {
        println(it)
    }
    val playerAgesList : List<Int> = listOf(32,27,14,52,101)
    playerAgesList.toIntArray().forEach { println(it) }

    val x = listOf(mutableListOf(1,2,3))
    val y = listOf(mutableListOf(1,2,3))
    println("equal x and y: ${x==y}")
    x[0].add(4)
    println("equal x and y: ${x==y}")

    var myList : List<Int> = listOf(1,2,3)
    (myList as MutableList)[2] = 1000
    println(myList)





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




