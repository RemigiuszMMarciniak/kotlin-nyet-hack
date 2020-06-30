const val TAVERN_NAME = "Szynk Hipolit'a"
fun main(args : Array<String>) {
//    placeOrder()
    placeOrder("shandy,Dragon Breath, 5.91")
    placeOrder("elixir,Pidgeon, 4.83")

    val capitalA :Char = 'A'
    println(capitalA)
    val unicodeCapitalA : Char = '\u0041'
    println(unicodeCapitalA)
    val omSymbol = '\u0950'
    println(omSymbol)
    "Dragon Breath".forEach {
        println("$it\n")
    }
}
private fun placeOrder(){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(6 until indexOfApostrophe)
    println("Mordowycz and $tavernMaster talk about the order")
}
private fun placeOrder(menuData : String){
    placeOrder()

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
//    destructurization
    val (type, name, price) = menuData.split(',')

    val message = "Mordowycz has bought $name ($type) for $price"
    println(message)

//    val phrase = "Wow... this $name is amazing!"
//    print("Mordowycz: ${toDragonSpeak(phrase)}")

    val phrase = if(name == "Dragon Breath"){
        "Mordowycz: ${toDragonSpeak("Wow... this $name is amazing! AAAAAAAAA")}"
    }else{
        "Mordowycz: thank you for $name"
    }
    println(phrase)
}

private fun toDragonSpeak(phrase : String) : String {
    return phrase.replace(Regex("[aeiouAEIOU]"),{
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
    })
}




