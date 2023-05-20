package sopt.sopkathon.weing.presentation.home

import android.content.Context
import android.content.Intent
import sopt.sopkathon.weing.R
import sopt.sopkathon.weing.databinding.ActivityHomeBinding
import sopt.sopkathon.weing.presentation.base.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }
}
