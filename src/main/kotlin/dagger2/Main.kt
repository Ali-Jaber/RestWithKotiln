package dagger2

fun main(args: Array<String>) {
    val dagger = DaggerCoffeeComponent.builder().sugar(3).build()
    println(dagger.getCoffee().getCoffeeCup())
}