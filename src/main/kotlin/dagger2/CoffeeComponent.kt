package dagger2

import dagger.Component

@Component
interface CoffeeComponent {
    fun getCoffee(): Coffee
}