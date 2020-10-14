package rxjava

import io.reactivex.rxjava3.subjects.PublishSubject

fun main(args: Array<String>) {
    val subject = PublishSubject.create<String>()

    subject.subscribe {i -> println("student1 $i")}
    subject.onNext("A")
    Thread.sleep(1000)
    subject.onNext("B")
    Thread.sleep(1000)
    subject.onNext("C")
    Thread.sleep(1000)
    subject.onNext("D")
    Thread.sleep(1000)
    subject.subscribe {i -> println("student2 $i")}
    subject.onNext("E")
    Thread.sleep(1000)
    subject.onNext("F")
    Thread.sleep(1000)
    subject.onNext("G")
}