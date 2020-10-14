package dagger2

fun main(args: Array<String>) {
    val dagger = DaggerCoffeeComponent.create()
    println(dagger.getCoffee().getCoffeeCup())
}