package model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class PostModelMoshi (
    @Json(name = "user_id") val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)