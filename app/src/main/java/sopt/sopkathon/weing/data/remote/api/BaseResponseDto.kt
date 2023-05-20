package sopt.sopkathon.weing.data.remote.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponseDto<T>(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val data: List<T> ? = null,
    @SerialName("message")
    val message: String
)