package edu.rmm.nyethack

class PlayerDwarf(_name:String, val health : Int){
    val race = "dwarf"
    var town = "Bavarten"
    val name = _name
    val alignment : String
    private var age = 0
    lateinit var fate :String

    init {
        println("initializing player")
        alignment = "GOOD"
    }

    constructor(_name: String) : this(_name, 100){
        town = "Shireburg"
    }
    private fun determineFate(){
        fate = "Great"
    }
    private fun proclaimFate(){
        if(::fate.isInitialized){
            println(fate)
        }
    }
}

fun main() {
    PlayerDwarf("Dent")
}