package sopt.sopkathon.weing.data.remote.entity

import retrofit2.Call
import retrofit2.http.GET
import sopt.sopkathon.weing.data.remote.api.ResponseScoreDto

interface ResponseScoreService {
    @GET("score")
    fun getScoreData(): Call<ResponseScoreDto>
}