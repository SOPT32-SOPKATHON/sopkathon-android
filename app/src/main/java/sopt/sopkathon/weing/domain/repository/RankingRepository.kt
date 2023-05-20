package sopt.sopkathon.weing.domain.repository

import sopt.sopkathon.weing.domain.model.OutOfRanking
import sopt.sopkathon.weing.domain.model.TopRanking

interface RankingRepository {
    suspend fun getTopRanking(): List<TopRanking>
    suspend fun getOutOfRanking(): List<OutOfRanking>
}
