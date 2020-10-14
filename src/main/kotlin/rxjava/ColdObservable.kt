package rxjava

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val cold = Observable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS)
    cold.subscribe { i -> println("output: student1: $i") }
    Thread.sleep(3000)
    cold.subscribe { i -> println("output: student2: $i") }
    Thread.sleep(5000)
}