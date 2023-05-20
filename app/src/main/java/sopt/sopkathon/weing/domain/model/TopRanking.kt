package sopt.sopkathon.weing.domain.model

data class TopRanking(
    val image: String,
    val title: String,
    val content: String,
    val likeCount: Int,
    val dislikeCount: Int,
)
