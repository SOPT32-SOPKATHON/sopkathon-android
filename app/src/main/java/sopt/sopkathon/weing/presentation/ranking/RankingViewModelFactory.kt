package sopt.sopkathon.weing.presentation.ranking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sopt.sopkathon.weing.domain.repository.RankingRepository

class RankingViewModelFactory(
    private val rankingRepository: RankingRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RankingViewModel::class.java)) {
            RankingViewModel(rankingRepository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}
