package sopt.sopkathon.weing.presentation.ranking

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import sopt.sopkathon.weing.R
import sopt.sopkathon.weing.data.datasource.RankingDataSourceImpl
import sopt.sopkathon.weing.data.remote.ServicePool
import sopt.sopkathon.weing.data.repository.RankingRepositoryImpl
import sopt.sopkathon.weing.databinding.ActivityRankingBinding
import sopt.sopkathon.weing.presentation.base.BindingActivity
import sopt.sopkathon.weing.presentation.ranking.adapter.RankingAdapter

class RankingActivity : BindingActivity<ActivityRankingBinding>(R.layout.activity_ranking) {
    private lateinit var rankingViewModel: RankingViewModel

    private val rankingAdapter: RankingAdapter by lazy { RankingAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        rankingViewModel.getTopRanking()
        rankingViewModel.getOutOfRanking()

        observeRanking()
        initAdapter()
    }

    private fun initViewModel() {
        val factory = RankingViewModelFactory(
            RankingRepositoryImpl(
                RankingDataSourceImpl(
                    ServicePool.rankingService,
                ),
            ),
        )
        rankingViewModel = ViewModelProvider(this, factory)[RankingViewModel::class.java]
        binding.viewModel = rankingViewModel
        binding.lifecycleOwner = this
    }

    private fun initAdapter() {
        binding.rvRankingRank.adapter = rankingAdapter
    }

    private fun observeRanking() {
        rankingViewModel.outOfRank.observe(this) {
            rankingAdapter.initData(it)
        }
    }
}
