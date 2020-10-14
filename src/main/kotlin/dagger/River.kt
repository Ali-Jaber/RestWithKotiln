package dagger

import org.jetbrains.kotlin.javax.inject.Inject
class River @Inject constructor(){

    fun getWater(): String {
        return "water"
    }
}