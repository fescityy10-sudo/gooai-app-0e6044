package com.gooai.generated

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var currentInput = ""
    private lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display = findViewById(R.id.display)
        val buttons = listOf(R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9)
        buttons.forEach { id -> findViewById<Button>(id).setOnClickListener { append(findViewById<Button>(id).text.toString()) } }
        findViewById<Button>(R.id.btnPlus).setOnClickListener { append("+") }
        findViewById<Button>(R.id.btnEqual).setOnClickListener { calculate() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { currentInput = ""; display.text = "0" }
    }

    private fun append(char: String) { currentInput += char; display.text = currentInput }
    private fun calculate() {
        try { val parts = currentInput.split("+"); display.text = (parts[0].toDouble() + parts[1].toDouble()).toString() }
        catch (e: Exception) { display.text = "خطأ" }
    }
}