package sopt.sopkathon.weing.domain.model

data class OutOfRanking(
    val rank: Int,
    val title: String,
    val content: String,
    val likeCount: Int,
    val dislikeCount: Int,
)
