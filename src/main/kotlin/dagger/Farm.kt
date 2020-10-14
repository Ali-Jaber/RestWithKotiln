package dagger

import org.jetbrains.kotlin.javax.inject.Inject

class Farm @Inject constructor() {

    fun getBeans(): String {
        return "beans"
    }
}