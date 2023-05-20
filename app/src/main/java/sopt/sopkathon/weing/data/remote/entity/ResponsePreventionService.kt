package sopt.sopkathon.weing.data.remote.entity

import retrofit2.Call
import retrofit2.http.GET
import sopt.sopkathon.weing.data.remote.api.BaseResponseDto
import sopt.sopkathon.weing.data.remote.api.ResponsePreventionDto

interface ResponsePreventionService {
    @GET("prevention")
    fun getPreventionData(): Call<BaseResponseDto<ResponsePreventionDto>>
}
