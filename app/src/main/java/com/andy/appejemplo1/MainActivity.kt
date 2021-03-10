package com.andy.appejemplo1

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import com.andy.appejemplo1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSend.setOnClickListener {
            val intent = Intent(this,ViewDataActivity::class.java)
            val heroe:String = viewBinding.etHeroName.text.toString()
            val powerLvl:Float = viewBinding.powerLevel.rating
            val heroePic:Bitmap = viewBinding.imgHeroPic.drawable.toBitmap()

            intent.putExtra(ViewDataActivity.HEROE_KEY, heroe)
            intent.putExtra(ViewDataActivity.POWER_KEY, powerLvl)
            intent.putExtra(ViewDataActivity.IMAGE_KEY, heroePic)

            startActivity(intent)
        }

        viewBinding.imgHeroPic.setOnClickListener {
            val intentImplicito = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intentImplicito, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1 && resultCode==Activity.RESULT_OK) {
            val image:Bundle? = data?.extras
            val heroImage:Bitmap? = image?.getParcelable("data")
            viewBinding.imgHeroPic.setImageBitmap(heroImage)
        }
    }
}