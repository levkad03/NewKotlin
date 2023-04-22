package com.example.lab5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lab5.databinding.ActivityThirdBinding

class thirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            binding.button3.setBackgroundColor(Color.GREEN)
            val intentProgrammerData = intent.getParcelableExtra<Programmer>("programmerData")
            val intentQuantity = intent.getIntExtra("quantity", -1)
            intentProgrammerData.let {
                if(intentQuantity != -1){
                    binding.textView.text = "$it $intentQuantity"
                }
            }
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lab5", "DestroyCalled")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("lab5", "saveCalled")
        outState.apply {
            putString("programmerData", binding.textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("lab5", "restoreCalled")
        savedInstanceState.run {
            binding.textView.text = getString("programmerData")
        }
    }
}