import com.squareup.moshi.Moshi
import model.PostModel
import model.PostModelMoshi


val apiInterface: ApiInterfaceMoshi = ApiClient.getApiClientMoshi().create(ApiInterfaceMoshi::class.java)
val json = """
{
   "user_id": 2,
   "id": 2,
   "title": "TEST MOSHI",
   "body": "MOSHI"
 } """

val moshi: Moshi = Moshi.Builder().build()
val adapter = moshi.adapter(PostModelMoshi::class.java)
val postModelFromJson = adapter.fromJson(json)
val postModelToJson = adapter.toJson(PostModelMoshi(3, 3, "try", "try"))
fun main(args: Array<String>) {


    println(postModelToJson)

    val postModel = PostModel(1, 1, "test", "test")
    val createPost = create(postModelFromJson!!)
    val fetchAllPosts = getList()
    val deletePost = delete(15)

    if (createPost.isSuccessful) {
        println(createPost.body())
    } else {
        println("Error")
    }

    if (fetchAllPosts.isSuccessful) {
        println("****************groupBy****************")
        val groupByFirstChar = fetchAllPosts.body()
            ?.sortedBy { it.title }
            ?.groupBy { it.body.first().toUpperCase() }

        groupByFirstChar?.forEach { e ->
            var i = 0
            println("${e.key}\n ${e.value[i++]}")
        }

        println("****************associateBy****************")
        val a = fetchAllPosts.body()?.associateBy { it.id }
        a?.forEach { e ->
            println("${e.key} ${e.value.title}")

        }

        println("****************filter****************")
        val titles = fetchAllPosts.body()
            ?.filter { n -> n.title.startsWith('s', true) }
            ?.map { it.title }
        titles?.forEach { e -> println(e) }

        val idGreaterThan50 = fetchAllPosts.body()
            ?.filter { post -> post.id > 50 }
            ?.sortedByDescending { it.id }
        idGreaterThan50?.forEach { e -> println(e.id) }

        val distinctTitle = fetchAllPosts.body()?.distinctBy { it.title }
        distinctTitle?.forEach { e -> println(e.title) }
    }

    if (deletePost.code() == 200) {
        println("Deleted Successfully")
    } else {
        println("Error happen when deleted")
    }
}

fun create(postModelMoshi: PostModelMoshi) = apiInterface.createPost(postModelMoshi).execute()

fun getList() = apiInterface.fetchAllPosts().execute()

fun delete(id: Int) = apiInterface.deletePost(id).execute()
