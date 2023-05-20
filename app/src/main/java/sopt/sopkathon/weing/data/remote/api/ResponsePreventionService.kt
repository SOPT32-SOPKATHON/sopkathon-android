package sopt.sopkathon.weing.data.remote.api

import retrofit2.Call
import retrofit2.http.GET
import sopt.sopkathon.weing.data.remote.entity.response.BaseResponseDto
import sopt.sopkathon.weing.data.remote.entity.response.ResponsePreventionDto

interface ResponsePreventionService {
    @GET("prevention")
    fun getPreventionData(): Call<BaseResponseDto<ResponsePreventionDto>>
}
