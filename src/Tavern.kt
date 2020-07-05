import java.io.File
import kotlin.math.roundToInt
import kotlin.reflect.typeOf

const val TAVERN_NAME = "Szynk Hipolit'a"
val patronList:MutableList<String> = listOf("Ela","Mordeczka","Zocha").toMutableList()
val lastName = listOf<String>("Ironfoot","Cutthroat","Plague")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
        .readText()
        .split("\n")

//val patronGold = mapOf("Ela" to 10.5, "Mordeczka" to 8.0, "Zocha" to 5.5)
//val patronGoldMutable = mutableMapOf("Ela" to 10.5, "Mordeczka" to 8.0, "Zocha" to 5.5)
var patronGold = mutableMapOf<String,Double>()

fun main(args : Array<String>) {

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        println(name)
        uniquePatrons+=name
    }
    println(uniquePatrons)

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }
    println(patronGold)
    println(uniquePatrons)

    var orderCount = 0
    while(orderCount <= 9){
        placeOrder(uniquePatrons.shuffled().first(),menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()

    println(patronGold)
    println(uniquePatrons)



//    patronGold = mutableMapOf("Zocha" to 5.0)
//    val patronGold2 = mutableMapOf("Zocha" to 5.0)
//    patronGold2 += "Zocha" to 5.5
//    println(patronGold2)
//    patronGold.plus("Zocha" to 5.0)
//    patronGold.put("John",6.6)
//    patronGold.putAll(listOf("Jane" to 5.0, "Jared" to 6.7))
//    println(patronGold.getOrPut("John",{5.5}))
//
//    println(patronGold)
//
//    println(patronGold)
//    var patronGoldUsingPair = mapOf<String,Double>(Pair("Ela",10.5),
//        Pair("Mordeczka",8.0),
//        Pair("Zocha",5.5))
//    println(patronGoldUsingPair)
//
//    patronGoldMutable += "Zocha" to 6.5
//
//    println(patronGoldMutable)
//
//    println(patronGoldMutable["Ela"])
//    println(patronGoldMutable["Mordeczka"])
//    println(patronGoldMutable["John"])
//    val mapValue = patronGoldMutable["John"] ?: "No value"
//    println(mapValue)




}
private fun displayPatronBalances(){
//    patronGold.forEach {
//        println("${it.key} : ${it.value}")
//    }
    patronGold.forEach{ (patron, balance) ->
        println("$patron : ${"%.2f".format(balance)}")
    }
}

private fun placeOrder(patronName:String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(6 until indexOfApostrophe)
    println("$patronName and $tavernMaster talk about the order")
}
private fun placeOrder(patronName:String, menuData : String){
    placeOrder(patronName)

    val (type, name, price) = menuData.split(',')
    checkPatronGold(price.toDouble(),patronName)
    try {
        performPurchase(price.toDouble(),patronName)
        val message = "$patronName has bought $name ($type) for $price"
        println(message)

        val phrase = if(name == "Dragon Breath"){
            "$patronName: ${toDragonSpeak("Wow... this $name is amazing! AAAAAAAAA")}"
        }else{
            "$patronName: thank you for $name"
        }
        println(phrase)
    }catch (e :NoSuchElementException){
        println("$patronName has no money! Leave the tavern now.")
    }


}
private fun performPurchase(price : Double,patronName: String){
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}
private fun checkPatronGold(price : Double,patronName: String){
    if(patronGold.getValue(patronName) <= 0){
        patronGold.remove(patronName)
        uniquePatrons.remove(patronName)
    }else{
        return
    }
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




