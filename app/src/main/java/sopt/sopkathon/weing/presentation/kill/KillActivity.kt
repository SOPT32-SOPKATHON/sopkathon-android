package sopt.sopkathon.weing.presentation.kill

import android.content.Intent
import android.os.Bundle
import sopt.sopkathon.weing.R
import sopt.sopkathon.weing.databinding.ActivityKillBinding
import sopt.sopkathon.weing.databinding.DialogVoteBinding
import sopt.sopkathon.weing.presentation.base.BindingActivity
import sopt.sopkathon.weing.presentation.home.HomeActivity

class KillActivity : BindingActivity<ActivityKillBinding>(R.layout.activity_kill) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //이미지 불러오기
        loadImage()

        //toolbar 백버튼
        binding.toolbar.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        //이미지 재로딩
        binding.btnKillReload.setOnClickListener {
            loadImage()
        }

        clickKillSuccessButton()
    }

    private fun loadImage() {

    }

    //해결했어요 버튼 클릭시
    private fun clickKillSuccessButton(){
        binding.btnKillSuccess.setOnClickListener{

            val dialog = VoteDialog()
            dialog.isCancelable = false
            dialog.show(this.supportFragmentManager, "VoteDialog")



        }
    }

}
