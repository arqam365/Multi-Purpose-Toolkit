package com.nextlevelprogrammers.toolkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calc() {
        val intent = Intent(this,Calculator::class.java)
        startActivity(intent)
    }

    fun flashlight() {
        val intent = Intent(this,FlashLight::class.java)
        startActivity(intent)
    }

    fun compass() {
        val intent = Intent(this,Compass::class.java)
        startActivity(intent)
    }
    fun mp3() {
        val intent = Intent(this,MusicPlayer::class.java)
        startActivity(intent)
    }
}
