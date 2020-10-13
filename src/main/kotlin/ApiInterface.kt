import model.PostAndCommentModel
import model.PostModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModel>>

    @GET("posts/{id}/comments")
    fun getPostDetails(@Path("id") id: Int): Call<List<PostAndCommentModel>>

    @POST("posts")
    fun createPost(@Body postModel: PostModel): Call<PostModel>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Call<PostModel>
}