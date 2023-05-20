package sopt.sopkathon.weing.data.remote.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RankingResponseDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Data>,
) {
    @Serializable
    data class Data(
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
