package sopt.sopkathon.weing.data.remote.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseScoreDto(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val data: Data,
    @SerialName("message")
    val message: String,
) {
    @Serializable
    data class Data(
        @SerialName("date")
        val date: String,
        @SerialName("house_score")
        val house_score: Double,
        @SerialName("park_score")
        val park_score: Double,
        @SerialName("water_score")
        val water_score: Double,
    )
}
