package sopt.sopkathon.weing.data.repository

import sopt.sopkathon.weing.data.datasource.RankingDataSource
import sopt.sopkathon.weing.data.mapper.RankingMapper.toDomainModelOfOut
import sopt.sopkathon.weing.data.mapper.RankingMapper.toDomainModelOfTop
import sopt.sopkathon.weing.domain.model.OutOfRanking
import sopt.sopkathon.weing.domain.model.TopRanking
import sopt.sopkathon.weing.domain.repository.RankingRepository

class RankingRepositoryImpl(
    private val rankingDataSource: RankingDataSource,
) : RankingRepository {

    override suspend fun getTopRanking(): List<TopRanking> {
        val rank = rankingDataSource.getRanking().data

        return rank.take(3).map { it.toDomainModelOfTop() }
    }

    override suspend fun getOutOfRanking(): List<OutOfRanking> {
        val rank = rankingDataSource.getRanking().data

        return rank.drop(3).map { it.toDomainModelOfOut() }
    }
}
