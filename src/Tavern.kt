import kotlin.math.roundToInt

const val TAVERN_NAME = "Szynk Hipolit'a"
const val GOLD_TO_DRAGON_COIN_RATE = 1.43
var playerDragonCoins = 5.0
var playerGold = (playerDragonCoins * GOLD_TO_DRAGON_COIN_RATE).toInt()
var playerSilver = ((playerDragonCoins * GOLD_TO_DRAGON_COIN_RATE) % 1 * 100).roundToInt()
var dragonBreathBarrels = 5.0
fun main(args : Array<String>) {
    println(playerGold)
    println(playerSilver)
//    placeOrder()
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("shandy,Dragon Breath, 5.91")
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
private fun placeOrder(){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(6 until indexOfApostrophe)
    println("Mordowycz and $tavernMaster talk about the order")
}
private fun placeOrder(menuData : String){
    placeOrder()

    val (type, name, price) = menuData.split(',')


    val isEnoughMoney = performPurchase(price.toDouble())

    if(isEnoughMoney){
        val message = "Mordowycz has bought $name ($type) for $price"
        println(message)

//    val gold : Int = "5.91".toIntOrNull() ?: 0


        val phrase = if(name == "Dragon Breath"){
            "Mordowycz: ${toDragonSpeak("Wow... this $name is amazing! AAAAAAAAA")}"
        }else{
            "Mordowycz: thank you for $name"
        }
        println(phrase)
    }else{
        println("Mordowycz doesn't have enough money")
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




