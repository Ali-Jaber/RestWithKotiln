package model

data class PostAndCommentModel(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)