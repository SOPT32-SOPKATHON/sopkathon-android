package sopt.sopkathon.weing.data.remote.api

import retrofit2.http.GET
import sopt.sopkathon.weing.data.remote.entity.response.RankingResponseDto

interface RankingService {

    @GET("kill")
    suspend fun getRanking(): RankingResponseDto
}
