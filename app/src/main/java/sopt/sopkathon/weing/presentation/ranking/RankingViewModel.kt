package sopt.sopkathon.weing.presentation.ranking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sopt.sopkathon.weing.domain.model.OutOfRanking
import sopt.sopkathon.weing.domain.model.TopRanking
import sopt.sopkathon.weing.domain.repository.RankingRepository

class RankingViewModel(
    private val rankingRepository: RankingRepository,
) : ViewModel() {
    private val _topRank: MutableLiveData<List<TopRanking>> = MutableLiveData()
    val topRank: LiveData<List<TopRanking>> get() = _topRank
    private val _outOfRank: MutableLiveData<List<OutOfRanking>> = MutableLiveData()
    val outOfRank: LiveData<List<OutOfRanking>> get() = _outOfRank

    fun getTopRanking() {
        viewModelScope.launch {
            _topRank.value = rankingRepository.getTopRanking()
        }
    }

    fun getOutOfRanking() {
        viewModelScope.launch {
            _outOfRank.value = rankingRepository.getOutOfRanking()
        }
    }
}
