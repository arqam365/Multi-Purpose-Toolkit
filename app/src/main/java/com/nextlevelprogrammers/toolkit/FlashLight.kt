package com.nextlevelprogrammers.toolkit

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi

class FlashLight : AppCompatActivity() {
    private lateinit var cameraM : CameraManager
    private lateinit var powerBtn : ImageButton
    private var isFlash = false
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_light)
        powerBtn = findViewById(R.id.power)
        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        powerBtn.setOnClickListener { flashLightOnRoOff() }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun flashLightOnRoOff() {
        if (!isFlash){
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,true)
            isFlash = true
            powerBtn.setImageResource(R.drawable.ic_power_on)
            textMessage("Flash Light is On",this)
        }
        else{
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,false)
            isFlash = false
            powerBtn.setImageResource(R.drawable.ic_power_off)
            textMessage("Flash Light is Off",this)
        }
    }

    private fun textMessage(s: String, c:Context) {
        Toast.makeText(c,s, Toast.LENGTH_SHORT).show()
    }

}