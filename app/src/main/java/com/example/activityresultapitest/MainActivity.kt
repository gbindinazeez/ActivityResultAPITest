package com.example.activityresultapitest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var textviewResult: TextView

    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            val result = result.data?.getIntExtra("result",0)
            textviewResult.text = "" + result
        }
        if (result.resultCode == RESULT_CANCELED){
            textviewResult.text = "Nothing selected"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textviewResult = findViewById(R.id.text_view_result)
        val editText1 = findViewById<EditText>(R.id.edit_text_number1)
        val editText2 = findViewById<EditText>(R.id.edit_text_number2)
        val button = findViewById<Button>(R.id.button_open_activity2)
        button.setOnClickListener {
            if (editText1.text.toString().equals("") || editText2.text.toString().equals("")){
                Toast.makeText(this, "Please Insert numbers", Toast.LENGTH_SHORT).show()
            } else {
                val number1 = editText1.text.toString().toInt()
                val number2 = editText2.text.toString().toInt()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("number1", number1)
                intent.putExtra("number2", number2)
                resultContract.launch(intent)
            }
        }
    }
}