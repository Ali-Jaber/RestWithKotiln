package dagger

@Component
interface CoffeeComponent {
    fun getCoffee(): Coffee
}