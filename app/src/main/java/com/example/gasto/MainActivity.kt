package com.example.gasto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gasto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSend.setOnClickListener(this)
    }

    override fun onClick(view: View) {
    if(view.id == R.id.button_send) {
        calculate()
        }
    }

    private fun calculate () {
        Toast.makeText(this, "Fui clicado", Toast.LENGTH_LONG).show()
    }
}