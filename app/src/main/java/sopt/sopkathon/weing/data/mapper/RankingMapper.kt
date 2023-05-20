package sopt.sopkathon.weing.data.mapper

import sopt.sopkathon.weing.data.remote.entity.response.RankingResponseDto
import sopt.sopkathon.weing.domain.model.OutOfRanking
import sopt.sopkathon.weing.domain.model.TopRanking

object RankingMapper {

    fun RankingResponseDto.Data.toDomainModelOfTop(): TopRanking = TopRanking(
        image = this.image,
        title = this.title,
        content = this.content,
        likeCount = this.like_count,
        dislikeCount = this.dislike_count,
    )

    fun RankingResponseDto.Data.toDomainModelOfOut(): OutOfRanking = OutOfRanking(
        rank = this.rank,
        title = this.title,
        content = this.content,
        likeCount = this.like_count,
        dislikeCount = this.dislike_count,
    )
}
