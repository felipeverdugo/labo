package com.felipe.aprendamosalimpiar.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.felipe.aprendamosalimpiar.R

class PasarNivel : AppCompatActivity() {

        private lateinit var tvView: TextView
        private lateinit var btnSalir : Button
        private lateinit var mensaje : String

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)


            setContentView(R.layout.activity_pasar_nivel)


            initComponents()
            initExtras()
            initListeners()



            tvView.text = mensaje


        }


    private fun initComponents() {
         tvView =findViewById(R.id.tvViewMensaje)
         btnSalir= findViewById(R.id.btnSalir)

    }


    private fun initExtras() {
        mensaje = intent.getStringExtra("MENSAJE").toString()
    }


    private fun initListeners() {

        btnSalir.setOnClickListener {

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            // Finalizar la actividad actual para que no quede en el stack
            finish()
        }

    }






}


