package sopt.sopkathon.weing.data.datasource

import sopt.sopkathon.weing.data.remote.api.RankingService
import sopt.sopkathon.weing.data.remote.entity.response.RankingResponseDto

class RankingDataSourceImpl(
    private val rankingService: RankingService,
) : RankingDataSource {

    override suspend fun getRanking(): RankingResponseDto {
        return rankingService.getRanking()
    }
}
