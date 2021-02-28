package com.example.activityresultapitest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.activityresultapitest.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    val resultIntent = Intent()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val number1 = intent.getIntExtra("number1",0)
        val number2 = intent.getIntExtra("number2",0)

        binding.textViewNumbers.text = "Numbers: " + number1 + ", " + number2
        binding.buttonAdd.setOnClickListener {
            val result = number1 + number2

            resultIntent.putExtra("result",result)

            setResult(RESULT_OK, resultIntent)
            finish()
        }

        binding.buttonSubtract.setOnClickListener {
            val result = number1 - number2

            resultIntent.putExtra("result",result)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

}