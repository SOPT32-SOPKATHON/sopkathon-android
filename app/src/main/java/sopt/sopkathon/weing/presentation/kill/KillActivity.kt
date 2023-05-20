package sopt.sopkathon.weing.presentation.kill

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Response
import sopt.sopkathon.weing.R
import sopt.sopkathon.weing.data.remote.api.ServicePool
import sopt.sopkathon.weing.data.remote.entity.response.ResponseKillDto
import sopt.sopkathon.weing.databinding.ActivityKillBinding
import sopt.sopkathon.weing.presentation.base.BindingActivity
import sopt.sopkathon.weing.presentation.home.HomeActivity

class KillActivity : BindingActivity<ActivityKillBinding>(R.layout.activity_kill) {
    private val killService = ServicePool.killService
    var imageItem: String? = ""
    private var killId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 이미지 불러오기
        loadImage()

        // toolbar 백버튼
        binding.toolbar.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        // 이미지 재로딩
        binding.btnKillReload.setOnClickListener {
            loadImage()
        }

        clickKillSuccessButton()

        // Dialog 띄우기
        binding.btnKillSuccess.setOnClickListener {
            val dialog = VoteDialog()
            val args = Bundle()
            args.putInt("killId", killId)
            dialog.arguments = args
            dialog.show(supportFragmentManager, "")
        }
    }

    private fun loadImage() {
        killService.getImage().enqueue(object : retrofit2.Callback<ResponseKillDto> {
            override fun onResponse(
                call: Call<ResponseKillDto>,
                response: Response<ResponseKillDto>,
            ) {
                imageItem = response.body()?.data?.image
                killId = response.body()?.data?.id ?: -1

                setImage(imageItem)
            }

            override fun onFailure(call: Call<ResponseKillDto>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    // 해결했어요 버튼 클릭시
    private fun clickKillSuccessButton() {
        binding.btnKillSuccess.setOnClickListener {
            val dialog = VoteDialog()
            dialog.isCancelable = false
            dialog.show(this.supportFragmentManager, "VoteDialog")
        }
    }

    private fun setImage(item: String?) {
        Glide.with(binding.root)
            .load(item)
            .into(binding.ivKillMethod)
    }
}
