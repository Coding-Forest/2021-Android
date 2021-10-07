package com.example.animmovingobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add_photo = replac with your own vector asset.
        val add_photo : ImageView = findViewById(R.id.add_photo)
        add_photo.setOnClickListener {
            add_photo.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction{  // finish animation with another anim.

                add_photo.animate().apply {
                    duration = 1000
                    rotationYBy(1800f)
                }.start()
            }
        }
    }
}
