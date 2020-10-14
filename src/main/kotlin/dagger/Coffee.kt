package dagger

import org.jetbrains.kotlin.javax.inject.Inject

class Coffee @Inject constructor(private val farm: Farm, private val river: River) {
    fun getCoffeeCup(): String {
        return "${river.getWater()} ${farm.getBeans()}"
    }
}