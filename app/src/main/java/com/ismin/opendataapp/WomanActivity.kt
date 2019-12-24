package com.ismin.opendataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class WomanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_woman)

        // Receive the info that comes from the FragmentMapTwo


        var sig = intent.getStringExtra("signal")


        val textID = findViewById<TextView>(R.id.textEachWoman)

        textID.text = sig


        var imgUrl = intent.getStringExtra("img")

        val imgID = findViewById<ImageView>(R.id.imageView)

        Glide.with(this).load(imgUrl).override(500, 500).into(imgID)


    }


}
