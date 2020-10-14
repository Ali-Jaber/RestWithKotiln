package rxjava

import io.reactivex.rxjava3.observables.ConnectableObservable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val hot:ConnectableObservable<Long> = ConnectableObservable.intervalRange(0,5,0,1,TimeUnit.SECONDS).publish()
    hot.connect()
    hot.subscribe { i -> println("output: student1: $i") }
    Thread.sleep(3000)
    hot.subscribe { i -> println("output: student2: $i") }
    Thread.sleep(4000)
}