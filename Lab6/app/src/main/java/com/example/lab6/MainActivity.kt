package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var replaceButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceButton = findViewById(R.id.button)
        val fragmentManager:FragmentManager = supportFragmentManager
        val fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()
        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.Frame, firstFragment)
        fragmentTransaction.commit()

        replaceButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.Frame, SecondFragment()).addToBackStack(null).commit()
        }
    }
}