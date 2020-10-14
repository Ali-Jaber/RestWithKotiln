package rxjava

import io.reactivex.rxjava3.subjects.ReplaySubject

fun main(args: Array<String>) {
    val replay = ReplaySubject.create<String>()
    replay.subscribe {i -> println("student1 $i")}
    replay.onNext("A")
    Thread.sleep(1000)
    replay.onNext("B")
    Thread.sleep(1000)
    replay.onNext("C")
    Thread.sleep(1000)
    replay.onNext("D")
    Thread.sleep(1000)
    replay.subscribe {i -> println("student2 $i")}
    replay.onNext("E")
    Thread.sleep(1000)
    replay.onNext("F")
    Thread.sleep(1000)
    replay.onNext("G")

}