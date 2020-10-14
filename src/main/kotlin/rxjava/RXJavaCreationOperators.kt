package rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun main(args: Array<String>) {

    val observer = object: Observer<String> {
        override fun onSubscribe(d: Disposable?) {
            println("onSubscribe")
        }

        override fun onNext(t: String?) {
            println("onNext $t")
        }

        override fun onError(e: Throwable?) {
            println("onError")
        }

        override fun onComplete() {
            println("onComplete")
        }

    }

    val observable = Observable.create(ObservableOnSubscribe<String> { emitter ->
        for (i in 0..5) {
            emitter.onNext("$i")
        }
        emitter.onComplete()
    })

    observable.subscribe(observer)
}