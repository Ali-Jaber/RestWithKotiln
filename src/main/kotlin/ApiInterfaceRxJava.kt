import io.reactivex.Observable
import model.PostAndCommentModel
import model.PostModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterfaceRxJava {
    @GET("posts")
    fun fetchAllPosts(): Observable<List<PostModel>>

    @GET("posts/{id}/comments")
    fun getPostDetails(@Path("id") id: Int): Observable<List<PostAndCommentModel>>

    @POST("posts")
    fun createPost(@Body postModel: PostModel): Observable<PostModel>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Observable<PostModel>
}