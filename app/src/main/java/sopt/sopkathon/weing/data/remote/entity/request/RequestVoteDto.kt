package sopt.sopkathon.weing.data.remote.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestVoteDto(
    @SerialName("type")
    val type: String,
)
