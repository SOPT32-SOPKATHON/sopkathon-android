package sopt.sopkathon.weing.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object BindingAdapter {
    @JvmStatic
    @androidx.databinding.BindingAdapter("glideSrc")
    fun setGlideImage(imageview: ImageView, image: String?) {
        if (image != null) {
            Glide.with(imageview.context)
                .load(image)
                .circleCrop()
                .into(imageview)
        }
    }
}
