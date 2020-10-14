import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import model.PostModel

val apiInterfaceRx: ApiInterfaceRxJava = ApiClientWithRxJava.getApiClinetRx().create(ApiInterfaceRxJava::class.java)
val posts = mutableListOf<PostModel>()
fun main(args: Array<String>) {
    val observable = apiInterfaceRx.fetchAllPosts()
    val compositeDisposable = CompositeDisposable()
    val observer = object: Observer<List<PostModel>> {
        override fun onSubscribe(d: Disposable?) {

        }

        override fun onNext(value: List<PostModel>?) {
            posts.addAll(value!!)
        }

        override fun onError(e: Throwable?) {
            println("onError: $e")
        }

        override fun onComplete() {
        }

    }
//    observable.subscribe(observer)
    compositeDisposable.add(observable.subscribe{o -> posts.addAll(o)})
    posts.forEach { e -> println("${e.id}") }
    compositeDisposable.clear()

}
