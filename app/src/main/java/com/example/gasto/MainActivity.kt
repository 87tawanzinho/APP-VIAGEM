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

    private fun isValid(): Boolean {
        val distance = binding.editDistance.text.toString()
        val price = binding.editPrice.text.toString()
        val autonomy = binding.editAutonomy.text.toString()

        return (distance != "" && price != "" && autonomy != "" && autonomy.toFloat() !== 0f)
    }
    private fun calculate () {
        if(isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()


            val totalValue = (distance  * price) / autonomy

            val totalValueStr = "R$ ${"%.2f".format(totalValue)}"
            binding.textValue.text = totalValueStr
        } else {
            Toast.makeText(this, R.string.fill_fields, Toast.LENGTH_LONG).show()
        }

    }
}