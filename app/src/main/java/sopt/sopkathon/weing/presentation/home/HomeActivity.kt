package sopt.sopkathon.weing.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import sopt.sopkathon.weing.R
import sopt.sopkathon.weing.data.remote.ServicePool
import sopt.sopkathon.weing.databinding.ActivityHomeBinding
import sopt.sopkathon.weing.presentation.base.BindingActivity
import sopt.sopkathon.weing.presentation.kill.KillActivity
import sopt.sopkathon.weing.presentation.ranking.RankingActivity
import sopt.sopkathon.weing.util.enqueueUtil

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewPager()
        initScore()
        onClickSiren()
        onClickMoreRanking()
        initRankingThree()
    }

    private fun initViewPager() {
        ServicePool.PreventionService.getPreventionData().enqueueUtil(
            onSuccess = {
                binding.vpHomeTip.adapter = HomeTipAdapter().apply {
                    submitList(it.data)
                }
            },
            onError = {
                Log.d(
                    "errrrr",
                    it.toString()
                )
            }
        )
    }

    private fun initScore(){
        ServicePool.ScoreService.getScoreData().enqueueUtil(
            onSuccess = {
                with(binding){
                tvHomeDate.text = it.data.date
                    when (scoreScope(it.data.house_score)) {
                        1 -> {
                            tvHomeResidentialScoreStage.text = "1단계"
                            tvHomeResidentialScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_pleasant)
                            tvHomeResidentialScoreText.text = "쾌적"
                            tvHomeResidentialScoreText.setTextColor(ContextCompat.getColor(this@HomeActivity ,R.color.pleasant_4F9D00))
                        }
                        2 -> {
                            tvHomeResidentialScoreStage.text = "2단계"
                            tvHomeResidentialScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_interest)
                            tvHomeResidentialScoreText.text = "관심"
                            tvHomeResidentialScoreText.setTextColor(ContextCompat.getColor(this@HomeActivity ,R.color.interest_FF5C00))
                        }
                        3 -> {
                            tvHomeResidentialScoreStage.text = "3단계"
                            tvHomeResidentialScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_warning)
                            tvHomeResidentialScoreText.text = "주의"
                            tvHomeResidentialScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.warning_FF5C00))
                        }
                        else -> {
                            tvHomeResidentialScoreStage.text = "4단계"
                            tvHomeResidentialScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_displeasure)
                            tvHomeResidentialScoreText.text = "불쾌"
                            tvHomeResidentialScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.displeasure_D9003C))
                        }
                    }
                    when (scoreScope(it.data.park_score)) {
                        1 -> {
                            tvHomeParkScoreStage.text = "1단계"
                            tvHomeParkScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_pleasant)
                            tvHomeParkScoreText.text = "쾌적"
                            tvHomeParkScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.pleasant_4F9D00))
                        }
                        2 -> {
                            tvHomeParkScoreStage.text = "2단계"
                            tvHomeParkScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_interest)
                            tvHomeParkScoreText.text = "관심"
                            tvHomeParkScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.interest_FF5C00))
                        }
                        3 -> {
                            tvHomeParkScoreStage.text = "3단계"
                            tvHomeParkScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_warning)
                            tvHomeParkScoreText.text = "주의"
                            tvHomeParkScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.warning_FF5C00))
                        }
                        else -> {
                            tvHomeParkScoreStage.text = "4단계"
                            tvHomeParkScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_displeasure)
                            tvHomeParkScoreText.text = "불쾌"
                            tvHomeParkScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.displeasure_D9003C))
                        }
                    }
                    tvHomeDate.text = it.data.date
                    when (scoreScope(it.data.water_score)) {
                        1 -> {
                            tvHomeWaterScoreStage.text = "1단계"
                            tvHomeWaterScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_pleasant)
                            tvHomeWaterScoreText.text = "쾌적"
                            tvHomeWaterScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.pleasant_4F9D00))
                        }
                        2 -> {
                            tvHomeWaterScoreStage.text = "2단계"
                            tvHomeWaterScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_interest)
                            tvHomeWaterScoreText.text = "관심"
                            tvHomeWaterScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.interest_FF5C00))
                        }
                        3 -> {
                            tvHomeWaterScoreStage.text = "3단계"
                            tvHomeWaterScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_warning)
                            tvHomeWaterScoreText.text = "주의"
                            tvHomeWaterScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.warning_FF5C00))
                        }
                        else -> {
                            tvHomeWaterScoreStage.text = "4단계"
                            tvHomeWaterScoreStage.background = ContextCompat.getDrawable(this@HomeActivity, R.drawable.rectangle_home_border_12dp_displeasure)
                            tvHomeWaterScoreText.text = "불쾌"
                            tvHomeWaterScoreText.setTextColor(ContextCompat.getColor(applicationContext ,R.color.displeasure_D9003C))
                        }
                    }
                    binding.tvHomeResidentialScore.text = it.data.house_score.toString()
                    binding.tvHomeParkScore.text = it.data.park_score.toString()
                    binding.tvHomeWaterScore.text = it.data.water_score.toString()
                }
            },
            onError = {
                Log.d("errrr", it.toString())
            }
        )
    }

    private fun scoreScope(score: Double): Int{
        if(score in 0.0 .. 25.0){
            return 1
        } else if(score in 25.1 .. 50.0){
            return 2
        } else if(score in 50.1 .. 75.0){
            return 3
        } else{
            return 4
        }
    }

    private fun onClickSiren(){
        binding.ivHomeSiren.setOnClickListener{
            startActivity(Intent(this, KillActivity::class.java))
        }
    }

    private fun onClickMoreRanking(){
        binding.tvHomeMoreRankingText.setOnClickListener {
            startActivity(Intent(this, RankingActivity::class.java))
        }
    }

    private fun initRankingThree() {
        lifecycleScope.launch {
            kotlin.runCatching {
                ServicePool.rankingService.getRanking()
            }.onSuccess {
                binding.tvHomeRanking1Title.text = it.data[0].title
                binding.tvHomeRanking2Title.text = it.data[1].title
                binding.tvHomeRanking3Title.text = it.data[2].title
            }.onFailure {

            }
        }

    }
}
