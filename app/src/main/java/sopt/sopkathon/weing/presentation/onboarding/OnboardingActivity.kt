package sopt.sopkathon.weing.presentation.onboarding

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.bumptech.glide.Glide
import sopt.sopkathon.weing.R
import sopt.sopkathon.weing.databinding.ActivityOnboardingBinding
import sopt.sopkathon.weing.presentation.base.BindingActivity
import sopt.sopkathon.weing.presentation.home.HomeActivity

class OnboardingActivity :
    BindingActivity<ActivityOnboardingBinding>(R.layout.activity_onboarding) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val img = binding.ivOnboardingGif
        Glide.with(this).load(R.drawable.gif_logo).into(img)
        Handler(Looper.getMainLooper()).postDelayed({
            binding.ivOnboardingMosquitto.visibility= View.VISIBLE
            binding.ivOnboardingCircle.visibility= View.VISIBLE
            binding.ivOnboardingGif.visibility=View.GONE
        }, 2000L)




        binding.ivOnboardingMosquitto.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()

        }


    }


}


