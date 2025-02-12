package com.felipe.aprendamosalimpiar.ui.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.felipe.aprendamosalimpiar.R

class PasarNivel : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_pasar_nivel)

            // Obtener el mensaje que se pasó a través del Intent
            val mensaje = intent.getStringExtra("MENSAJE")

            // Mostrar el mensaje en un TextView
            val tvView: TextView = findViewById(R.id.tvViewMensaje)
            tvView.text = mensaje
        }
    }


