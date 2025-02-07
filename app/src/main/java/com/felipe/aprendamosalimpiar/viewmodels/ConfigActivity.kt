package com.felipe.aprendamosalimpiar.viewmodels

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.felipe.aprendamosalimpiar.R
import com.felipe.aprendamosalimpiar.models.Dificultad


class ConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        val btnFacil = findViewById<Button>(R.id.btnFacil)
        btnFacil.text = Dificultad.FACIL.name
        val btnMedio = findViewById<Button>(R.id.btnMedio)
        btnMedio.text = Dificultad.MEDIO.name
        val btnDificil = findViewById<Button>(R.id.btnDificil)
        btnDificil.text = Dificultad.DIFICIL.name


        btnFacil.setOnClickListener {
            Toast.makeText(this, "Dificultad: Fácil seleccionada", Toast.LENGTH_SHORT).show()
        }

        btnMedio.setOnClickListener {
            Toast.makeText(this, "Dificultad: Medio seleccionada", Toast.LENGTH_SHORT).show()
        }

        btnDificil.setOnClickListener {
            Toast.makeText(this, "Dificultad: Difícil seleccionada", Toast.LENGTH_SHORT).show()
        }


        }


    }




