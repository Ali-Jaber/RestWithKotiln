package rxjava

import io.reactivex.rxjava3.subjects.AsyncSubject

fun main(args: Array<String>) {
    val async = AsyncSubject.create<String>()
    async.subscribe { i -> println("student1 $i") }
    async.onNext("A")
    Thread.sleep(1000)
    async.onNext("B")
    Thread.sleep(1000)
    async.onNext("C")
    Thread.sleep(1000)
    async.onNext("D")
    Thread.sleep(1000)
    async.subscribe { i -> println("student2 $i") }
    async.onNext("E")
    Thread.sleep(1000)
    async.onNext("F")
    Thread.sleep(1000)
    async.onNext("G")
    async.onComplete()

}