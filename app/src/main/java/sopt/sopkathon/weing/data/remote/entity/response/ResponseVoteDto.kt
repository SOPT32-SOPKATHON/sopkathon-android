package sopt.sopkathon.weing.data.remote.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseVoteDto(
    @SerialName("code")
    val code: Int,
    val message: String,
    val data: VoteData,
) {
    @Serializable
    data class VoteData(
        @SerialName("id")
        val id: Int,
        @SerialName("rank")
        val rank: Int,
        @SerialName("image")
        val image: String,
        @SerialName("title")
        val title: String,
        @SerialName("content")
        val content: String,
        @SerialName("like_count")
        val like_count: Int,
        @SerialName("dislike_count")
        val dislike_count: Int,
    )
}
