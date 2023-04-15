package com.nextlevelprogrammers.toolkit

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class Calculator : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun numberEvent(view: View) {
        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
        // Vibrate for 500 milliseconds
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(50,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            v.vibrate(50)
        }
        val editText = findViewById<EditText>(R.id.editText)
        val bu1 = findViewById<Button>(R.id.bu1)
        val bu2 = findViewById<Button>(R.id.bu2)
        val bu3 = findViewById<Button>(R.id.bu3)
        val bu4 = findViewById<Button>(R.id.bu4)
        val bu5 = findViewById<Button>(R.id.bu5)
        val bu6 = findViewById<Button>(R.id.bu6)
        val bu7 = findViewById<Button>(R.id.bu7)
        val bu8 = findViewById<Button>(R.id.bu8)
        val bu9 = findViewById<Button>(R.id.bu9)
        val bu0 = findViewById<Button>(R.id.bu0)
        val buDot = findViewById<Button>(R.id.buDot)
        val buPlusMinus = findViewById<Button>(R.id.buPlusMinus)
        if (isNewOp)
            editText.setText("")
        isNewOp = false
        var click = editText.text.toString()
        var buselect = view as Button
        when(buselect.id){
            bu1.id -> {click += "1"}
            bu2.id -> {click += "2"}
            bu3.id -> {click += "3"}
            bu4.id -> {click += "4"}
            bu5.id -> {click += "5"}
            bu6.id -> {click += "6"}
            bu7.id -> {click += "7"}
            bu8.id -> {click += "8"}
            bu9.id -> {click += "9"}
            bu0.id -> {click += "0"}
            buDot.id -> {click += "."}
            buPlusMinus.id -> {click = "-$click"}
        }
        editText.setText(click)
    }

    fun operatorEvent(view: View) {
        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
        // Vibrate for 500 milliseconds
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(50,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            v.vibrate(50)
        }
        val editText = findViewById<EditText>(R.id.editText)
        val buPlus = findViewById<Button>(R.id.buPlus)
        val buMinus = findViewById<Button>(R.id.buMinus)
        val buMultiply = findViewById<Button>(R.id.buMultiply)
        val buDivide = findViewById<Button>(R.id.buDivide)
        isNewOp = true
        oldNumber = editText.text.toString()
        var buselect = view as Button
        when(buselect.id){
            buPlus.id -> {op = "+"}
            buMinus.id -> {op = "-"}
            buMultiply.id -> {op = "*"}
            buDivide.id -> {op = "/"}
        }
    }

    fun equalEvent(view: View) {
        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
        // Vibrate for 500 milliseconds
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(50,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            v.vibrate(50)
        }
        val editText = findViewById<EditText>(R.id.editText)
        var newnumber = editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newnumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newnumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newnumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newnumber.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun acEvent(view: View) {
        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
        // Vibrate for 500 milliseconds
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(50,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            v.vibrate(50)
        }
        val editText = findViewById<EditText>(R.id.editText)
        editText.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {
        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
        // Vibrate for 500 milliseconds
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(50,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            v.vibrate(50)
        }
        val editText = findViewById<EditText>(R.id.editText)
        var no = editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isNewOp = true
    }

    fun delete(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        var word = editText.text.toString()
        if (word.isNotEmpty()) {
            editText.setText(word.substring(0, word.length - 1)) }
    }
}