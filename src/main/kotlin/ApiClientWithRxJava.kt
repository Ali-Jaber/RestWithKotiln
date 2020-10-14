import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClientWithRxJava {

    private fun createRetrofitBuilder(): Retrofit.Builder {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(100,TimeUnit.SECONDS)
            .connectTimeout(100,TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    fun getApiClinetRx(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return createRetrofitBuilder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}