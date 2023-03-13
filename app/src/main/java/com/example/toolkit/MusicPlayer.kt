package com.example.toolkit

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar

class MusicPlayer : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        val mediaplayer = MediaPlayer.create(this,R.raw.music)
        val mediaplayer1 = MediaPlayer.create(this,R.raw.music2)

        val seekbar = findViewById<SeekBar>(R.id.seekbar)
        seekbar.progress = 0

        seekbar.max = mediaplayer.duration

        var play_btn = findViewById<ImageButton>(R.id.play_btn)
        play_btn.setOnClickListener {
            if (!mediaplayer.isPlaying){
                mediaplayer.start()
                play_btn.setImageResource(R.drawable.ic_baseline_pause_24)
            }else{
                mediaplayer.pause()
                play_btn.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
        var next_btn = findViewById<ImageButton>(R.id.next)
        next_btn.setOnClickListener {
            if (!mediaplayer1.isPlaying){
                mediaplayer1.start()
                play_btn.setImageResource(R.drawable.ic_baseline_pause_24)
            }
        }
        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if (changed){
                    mediaplayer.seekTo(pos)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        runnable = Runnable {
            seekbar.progress = mediaplayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)

        mediaplayer.setOnCompletionListener {
            play_btn.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            seekbar.progress = 0
        }
    }
}