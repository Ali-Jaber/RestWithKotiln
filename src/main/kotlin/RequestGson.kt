import com.google.gson.Gson
import model.PostModel
import java.io.File

val apiInterfaceGson: ApiInterface = ApiClient.getApiClientGson().create(ApiInterface::class.java)

fun main(args: Array<String>) {

    val postModel = PostModel(1, 1, "test", "test")
    val json = """
{
   "user_id": 2,
   "id": 2,
   "title": "TEST GSON",
   "body": "GSON"
 } """

    val fromJson = Gson().fromJson(json, PostModel::class.java)
    val createPost = apiInterfaceGson.createPost(fromJson).execute()
    val fetchPosts = apiInterfaceGson.fetchAllPosts().execute()
    val postDetail = getPostDetail(1)

    if (createPost.isSuccessful) {
        println(createPost.body())
    } else {
        println("Error")
    }

    if (fetchPosts.isSuccessful) {
        println("****************groupBy****************")
        val groupByFirstChar = fetchPosts.body()?.groupBy { it.body.first().toUpperCase() }
        groupByFirstChar?.forEach { e ->
            var i = 0
            println("${e.key}\n ${e.value[i]}")
        }

        println("****************associateBy****************")
        val a = fetchPosts.body()?.associateBy { it.id }
        a?.forEach { e -> println("${e.key} ${e.value.title}")

        }

        println("****************filter****************")
        val evenLength = fetchPosts.body()?.filter { n -> n.body.length % 2 == 0 }
        evenLength?.forEach { e -> println("${e.id}, ${e.userId}, ${e.title}, ${e.body}") }
    }

    if(postDetail.isSuccessful) {
        val groupByPost = postDetail.body()?.groupBy { it.postId }
        println(groupByPost)

        val nameFilter = postDetail.body()?.filter { it.name.endsWith('m', true) }
            ?.sortedBy { it.email }
        println(nameFilter)

        val fileName = "postsdtails.txt"
        var fileObject = File(fileName)
        fileObject.writeText(postDetail.body().toString())
    }
}

fun getPostDetail(id: Int) = apiInterfaceGson.getPostDetails(id).execute()