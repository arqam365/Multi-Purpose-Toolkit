package com.example.toolkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calc(view: View) {
        val intent = Intent(this,Calculator::class.java)
        startActivity(intent)
    }

    fun flashlight(view: View) {
        val intent = Intent(this,FlashLight::class.java)
        startActivity(intent)
    }

    fun compass(view: View) {
        val intent = Intent(this,Compass::class.java)
        startActivity(intent)
    }
    fun mp3(view: View) {
        val intent = Intent(this,MusicPlayer::class.java)
        startActivity(intent)
    }
}
