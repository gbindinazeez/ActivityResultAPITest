package com.example.activityresultapitest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textView = findViewById<TextView>(R.id.text_view_numbers)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttoSub = findViewById<Button>(R.id.button_subtract)

        val intent = getIntent()
        val number1 = intent.getIntExtra("number1",0)
        val number2 = intent.getIntExtra("number2",0)

        textView.text = "Numbers: " + number1 + ", " + number2
        buttonAdd.setOnClickListener {
            val result = number1 + number2

            val resultIntent = Intent()
            resultIntent.putExtra("result",result)

            setResult(RESULT_OK, resultIntent)
            finish()
        }

        buttoSub.setOnClickListener {
            val result = number1 - number2

            val resultIntent = Intent()
            resultIntent.putExtra("result",result)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

}