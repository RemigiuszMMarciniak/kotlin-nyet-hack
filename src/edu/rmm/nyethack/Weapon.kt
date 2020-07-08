package edu.rmm.nyethack

open class WeaponSword(val name: String, val type:String){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WeaponSword

        if (name != other.name) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}

fun main() {
    println(WeaponSword("Chris","dagger") == WeaponSword("Chris","dagger"))
    println(WeaponSword("Chris","dagger") === WeaponSword("Chris","dagger"))
}