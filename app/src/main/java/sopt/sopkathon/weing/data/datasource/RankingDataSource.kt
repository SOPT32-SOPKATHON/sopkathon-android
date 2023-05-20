package sopt.sopkathon.weing.data.datasource

import sopt.sopkathon.weing.data.remote.entity.response.RankingResponseDto

interface RankingDataSource {

    suspend fun getRanking(): RankingResponseDto
}
