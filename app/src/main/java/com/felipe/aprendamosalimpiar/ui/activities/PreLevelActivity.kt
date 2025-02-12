package com.felipe.aprendamosalimpiar.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.felipe.aprendamosalimpiar.R

class PreLevelActivity : AppCompatActivity() {


    private lateinit var nombreDificultad : String
    private lateinit var nombreNivel : String

    private lateinit var btnSiguente : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_level)
        initComponents()
        initListeners()


    }


    private fun initComponents() {

        btnSiguente = findViewById<Button>(R.id.btnSiguiente)

    }


    private fun initListeners() {

        btnSiguente.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("EXTRA DIFICULTAD",intent.extras?.getString("EXTRA DIFICULTAD").orEmpty())
            intent.putExtra("EXTRA NIVEL", intent.extras?.getString("EXTRA NIVEL").orEmpty())
            startActivity(intent)

        }

    }


}







