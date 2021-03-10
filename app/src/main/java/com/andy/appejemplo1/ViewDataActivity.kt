package com.andy.appejemplo1

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andy.appejemplo1.databinding.ActivityViewDataBinding

class ViewDataActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityViewDataBinding
    companion object {
        const val HEROE_KEY = "heroe_key"
        const val POWER_KEY = "power_key"
        const val IMAGE_KEY = "image_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityViewDataBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val sentIntent:Bundle = intent.extras!!
        viewBinding.tvSentHeroName.text = sentIntent.getString(HEROE_KEY)
        viewBinding.ratingBar.rating = sentIntent.getFloat(POWER_KEY)
        viewBinding.sentPhoto.setImageBitmap(sentIntent.getParcelable(IMAGE_KEY))

    }
}