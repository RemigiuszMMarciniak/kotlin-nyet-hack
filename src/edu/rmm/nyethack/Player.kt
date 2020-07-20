package edu.rmm.nyethack

import java.io.File

class Weapon(val name: String)

class Player(_name: String,
            override var healthPoints: Int = 100,
            val isBlessed : Boolean,
            private val isImmortal: Boolean) : Fightable{
    var weapon : Weapon? = Weapon("Hebanowy Kris")
    fun printWeaponName(){
        weapon?.also {
            print(it.name)
        }
    }

    var name = _name
    get() = "${field.capitalize()} from $hometown"
    private set(value){
        field = value.trim()
    }

    val hometown by lazy{ selectHometown() }

    private fun selectHometown(): String {
        return File("data/towns.txt")
                .readText()
                .split("\n")
                .shuffled()
                .first()
    }

    init {
        require(healthPoints > 0) { "HP must be > 0 !"}
        require(name.isNotBlank()) {"NAme must not be null!"}
    }


    constructor(name:String) : this(name,
            isBlessed = true,
            isImmortal = false){
        if (name.toLowerCase() == "jan"){
            healthPoints = 40
        }
    }

    var currentPosition = Coordinate(0,0)
    val differentPosition = currentPosition.copy(x=2)


    override fun toString(): String {
        return "$name in $currentPosition"
    }

    fun castFireball (numFireballs:Int = 2) = println("Fireball! x $numFireballs")


    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREENY AURA" else "NO AURA"
        return auraColor
    }

    fun formatHealthStatus(): String {
        val healthStatus = when (healthPoints) {
            100 -> "is of great health!"
            in 90..99 -> "has some scrapes"
            in 75..89 -> if (isBlessed) {
                "has several minor wounds but recovers quickly!"
            } else {
                "has several minor wounds"
            }
            in 15..74 -> "has serious wounds"
            else -> "is in bad condition"
        }
        return healthStatus
    }

    override val diceCount = 3
    override val diceSides = 6

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed){
            damageRoll * 2
        }else{
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }
}
