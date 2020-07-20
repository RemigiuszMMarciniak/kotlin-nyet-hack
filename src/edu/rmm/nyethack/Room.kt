package edu.rmm.nyethack

open class Room(val name : String){
    protected open val dangerLevel = 5
    var monster:Monster? = Goblin()
    open fun description() = "Room: $name \n" +
            "Danger level: $dangerLevel . \n"+
            "Monster : ${monster?.description ?: "empty"}"
    open fun load() = "There is nothing interesting..."

}

open class TownSquare : Room("Town square"){
    override val dangerLevel = super.dangerLevel - 3
    override fun load() = "People are greeting you while you are entering the town \n ${ringBell()}"
//    final override fun load() = "People are greeting you while you are entering the town \n ${ringBell()}"
    private var bellSound = "RIING"
    private fun ringBell() = "Bell rings when you enter the town. $bellSound"
}
class Piazza : TownSquare(){
    override fun description(): String {
        return super.description() + " Piazza"
    }
}