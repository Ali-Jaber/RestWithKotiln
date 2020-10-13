import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class Address(
    var city: String? = null,
    var post: String? = null
)

data class Student(
    var name: String? = null,
    var address: Address? = null
)

fun main(args: Array<String>) {

    val student = Student("Ali", Address("Amman", "1200")) // object
    val json = Gson().toJson(student)  // json string
    println(json)

//    val json1 = ""
//{
//    "name": "Mark",
//    "address": "London"
// }""

    val json2 = """
{
   "name": "Ali",
   "address": {
        "city": "Zarqa",
        "post": "1000"
    }
 } """

    val fromJson = Gson().fromJson(json2, Student::class.java)
    println(fromJson.toString())

    val list = listOf(
        Student("Moahmmed", Address("Zarqa", "1200")),
        Student("Ali", Address("Amman", "1500"))
    )
    val gson = Gson()
    val jsonString = gson.toJson(list)
    val sType = object : TypeToken<List<Student>>() {}.type
    val otherList = gson.fromJson<List<Student>>(jsonString, sType)
    println("******************")
    println(jsonString)
    println(otherList)

}