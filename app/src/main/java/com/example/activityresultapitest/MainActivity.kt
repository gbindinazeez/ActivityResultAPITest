package com.example.activityresultapitest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.activityresultapitest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOpenActivity2.setOnClickListener {
            openForResult()
        }
    }

    private fun openForResult(){
        if (binding.editTextNumber1.text.toString().equals("") || binding.editTextNumber2.text.toString().equals("")){
            Toast.makeText(this, "Please Insert numbers", Toast.LENGTH_SHORT).show()
        } else {
            val number1 = binding.editTextNumber1.text.toString().toInt()
            val number2 = binding.editTextNumber2.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("number1", number1)
                putExtra("number2", number2)
            }
            resultContract.launch(intent)
        }
    }

    private val resultContract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            val resultReceived = result.data?.getIntExtra("result",0)
            binding.textViewResult.text = "" + resultReceived.toString()
        }
        if (result.resultCode == RESULT_CANCELED){
            binding.textViewResult.text = "Nothing selected"
        }
    }
}