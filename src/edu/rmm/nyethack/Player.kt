package edu.rmm.nyethack

class Weapon(val name: String)

class Player{
    var weapon : Weapon? = Weapon("Hebanowy Kris")
    fun printWeaponName(){
        weapon?.also {
            print(it.name)
        }
    }

    var name = "Mordowycz"
    get() = field.capitalize()
    private set(value){
        field = value.trim()
    }

    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false


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

}
