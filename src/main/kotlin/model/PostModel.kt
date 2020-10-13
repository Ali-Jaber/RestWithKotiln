package model

import com.google.gson.annotations.SerializedName

data class PostModel(
    @SerializedName("user_id") val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)