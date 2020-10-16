package dagger2

import javax.inject.Inject
import javax.inject.Named


class Coffee @Inject constructor(private val farm: Farm,
                                 private val river: River,
                                 @Named("sugar") private val sugar: Int,
                                 @Named("milk") private val milk: Int) {
    fun getCoffeeCup(): String {
        return "${river.getWater()} ${farm.getBeans()} sugar: $sugar and milk $milk"
    }
}