package com.vin.pdms5.views

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vin.pdms5.views.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.estadoCivilSp.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val estadoCivil = parent?.getItemAtPosition(position).toString()
                if (estadoCivil == "Casado") {
                    amb.conjugeLl.visibility = View.VISIBLE
                } else {
                    amb.conjugeLl.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                amb.conjugeLl.visibility = View.GONE
                amb.nomeConjugeEt.setText("")
                amb.sobrenomeConjugeEt.setText("")
            }
        }
    }
}