package com.example.lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab5.databinding.ActivitySecondBinding

class secondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            val data = binding.editTextTextPersonName.text.toString().split(" ")
            val programmerData = Programmer(data[0], data[1].toInt(), data[2])
            startActivity(Intent(this, thirdActivity::class.java).apply {
                putExtra("programmerData", programmerData)
                putExtra("quantity", 1)
            })
        }
    }
}