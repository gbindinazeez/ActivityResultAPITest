package com.example.activityresultapitest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    val textview = findViewById<TextView>(R.id.textView)
    val button = findViewById<Button>(R.id.button_get_result)

    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            textview.text = "I got the result"
        } else {
            textview.text = "Failed to get result "
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            resultContract.launch(intent)
        }
    }
}