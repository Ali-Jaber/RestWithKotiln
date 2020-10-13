import model.PostModelMoshi
import retrofit2.Call
import retrofit2.http.*

interface ApiInterfaceMoshi {
    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModelMoshi>>

    @POST("posts")
    fun createPost(@Body postModel: PostModelMoshi): Call<PostModelMoshi>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Call<PostModelMoshi>
}