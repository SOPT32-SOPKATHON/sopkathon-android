package sopt.sopkathon.weing.presentation.kill

import retrofit2.Call
import retrofit2.http.GET
import sopt.sopkathon.weing.data.remote.entity.response.ResponseKillDto

interface KillService {
    @GET("/kill/random")
    fun getImage(): Call<ResponseKillDto>
}
