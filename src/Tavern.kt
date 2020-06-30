fun main(args : Array<String>) {
//    println(args)
//    var beverage = readLine()
//    beverage = null
    //null safety
//    var beverage = readLine().capitalize()

//    1st solution ?.
//    var beverage = readLine()?.capitalize()

//    var beverage = readLine()?.let {
//        if(it.isNotBlank()){
//            it.capitalize()
//        }else{
//            "Grzaniec na porterze"
//        }
//    }
//

//    2nd solution !!.
//    var beverage = readLine()!!.capitalize()

//    3rd option
//    var beverage = readLine()
//
//    if (beverage != null){
//        beverage = beverage.capitalize()
//    }else{
//        println("Beverage is null!")
//    }
//    print(beverage)

//    var string : String? = null
//    string!!.capitalize()

//    var beverage = readLine()
//    beverage = beverage?.capitalize()?.plus(", big")
//    print(beverage)

//    null coalescing operator ?:

//    var beverage = readLine()
//    if (beverage != null){
//        beverage = beverage.capitalize()
//    }else{
//        println("Beverage is null!")
//    }
//    val beverageServed : String = beverage ?: "Grzaniec na porterze"
//    print(beverageServed)

    var beverage = readLine()
    beverage?.let {
        beverage = it.capitalize()
    } ?: println("beverage is null")

}